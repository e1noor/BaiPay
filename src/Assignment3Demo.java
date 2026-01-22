import java.time.LocalDate;

public class Assignment3Demo {
    public static void main(String[] args) {



        DatabaseManager db = new DatabaseManager();

        db.testConnection();




        Income bonusIncome = new Income(
                45000.0,
                LocalDate.now(),
                "Жазғы бонус",
                "Жұмыс",
                "BONUS"
        );
        db.createIncome(bonusIncome, 1); // user_id = 1


        db.readAllIncomes();


        System.out.println("Changing expense ID 3 from 70000 to 75000:");
        db.updateExpense(3, 75000.0);


        System.out.println("Deleting record ID 5:");
        db.deleteRecord(5);


        db.readExpensesByCategory("Тамақ");

        db.readAllUsers();


        db.testConnection();

        db.close();


    }
}