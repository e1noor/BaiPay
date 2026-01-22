import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/finance_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "3273"; // Your password

    private Connection connection;

    public DatabaseManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL database");
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public void createIncome(Income income, int userId) {
        String sql = "INSERT INTO financial_records " +
                "(user_id, record_type, amount, record_date, description, income_source, income_type) " +
                "VALUES (?, 'INCOME', ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setDouble(2, income.getAmount());
            pstmt.setDate(3, Date.valueOf(income.getDate()));
            pstmt.setString(4, income.getDescription());
            pstmt.setString(5, income.getSource());
            pstmt.setString(6, income.getType());

            int rows = pstmt.executeUpdate();
            System.out.println("Created: " + rows + " income record");
        } catch (SQLException e) {
            System.err.println("Create error: " + e.getMessage());
        }
    }

    public List<Income> readAllIncomes() {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM financial_records WHERE record_type = 'INCOME'";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {
                Income income = new Income(
                        rs.getDouble("amount"),
                        rs.getDate("record_date").toLocalDate(),
                        rs.getString("description"),
                        rs.getString("income_source"),
                        rs.getString("income_type")
                );
                incomes.add(income);
                System.out.println("   - " + income.getShortInfo() +
                        " | Date: " + income.getDate());
            }
            System.out.println("Total: " + incomes.size() + " income records");
        } catch (SQLException e) {
            System.err.println("Read error: " + e.getMessage());
        }
        return incomes;
    }

    public void updateExpense(int recordId, double newAmount) {
        String sql = "UPDATE financial_records SET amount = ? WHERE id = ? AND record_type = 'EXPENSE'";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, newAmount);
            pstmt.setInt(2, recordId);

            int rows = pstmt.executeUpdate();
            System.out.println("Updated: " + rows + " expense record(s)");

            if (rows > 0) {
                String selectSql = "SELECT description, amount FROM financial_records WHERE id = ?";
                PreparedStatement selectStmt = connection.prepareStatement(selectSql);
                selectStmt.setInt(1, recordId);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("   Now: " + rs.getString("description") +
                            " = " + rs.getDouble("amount") + " ₸");
                }
            }
        } catch (SQLException e) {
            System.err.println("Update error: " + e.getMessage());
        }
    }

    public void deleteRecord(int recordId) {
        String selectSql = "SELECT record_type, description, amount FROM financial_records WHERE id = ?";
        String deleteSql = "DELETE FROM financial_records WHERE id = ?";

        try {
            PreparedStatement selectStmt = connection.prepareStatement(selectSql);
            selectStmt.setInt(1, recordId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                System.out.print("️Deleting: " + rs.getString("record_type") +
                        " - " + rs.getString("description") +
                        " (" + rs.getDouble("amount") + " ₸)... ");
            }

            PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
            deleteStmt.setInt(1, recordId);
            int rows = deleteStmt.executeUpdate();

            System.out.println(rows + " record(s) deleted");

        } catch (SQLException e) {
            System.err.println("Delete error: " + e.getMessage());
        }
    }

    public List<Expense> readExpensesByCategory(String category) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM financial_records " +
                "WHERE record_type = 'EXPENSE' AND expense_category = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\nEXPENSES IN CATEGORY: " + category);
            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getDouble("amount"),
                        rs.getDate("record_date").toLocalDate(),
                        rs.getString("description"),
                        rs.getString("expense_category"),
                        rs.getString("expense_type")
                );
                expenses.add(expense);
                System.out.println("   - " + expense.getShortInfo() +
                        " | Date: " + expense.getDate());
            }
            System.out.println("Total: " + expenses.size() + " expense records");
        } catch (SQLException e) {
            System.err.println("Filter error: " + e.getMessage());
        }
        return expenses;
    }

    public List<User> readAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nUSERS IN DATABASE:");
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                users.add(user);
                System.out.println("   - ID: " + user.getId() +
                        ", Name: " + user.getName());
            }
        } catch (SQLException e) {
            System.err.println("User read error: " + e.getMessage());
        }
        return users;
    }

    public void testConnection() {
        try {
            String sql = "SELECT COUNT(*) as total_records FROM financial_records";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Database contains: " + rs.getInt("total_records") + " financial records");
            }
        } catch (SQLException e) {
            System.err.println("Test error: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            System.err.println("Close error: " + e.getMessage());
        }
    }
}