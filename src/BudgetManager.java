import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class BudgetManager {
    private List<FinancialRecord> allRecords = new ArrayList<>();

    public List<FinancialRecord> getAllRecords() {
        return new ArrayList<>(allRecords); // Көшірмесін қайтару
    }

    public void addIncome(Income income) {
        allRecords.add(income);
    }

    public void addExpense(Expense expense) {
        allRecords.add(expense);
    }

    public List<FinancialRecord> getThisMonthRecords() {
        LocalDate now = LocalDate.now();
        return allRecords.stream()
                .filter(record -> record.getDate().getMonth() == now.getMonth() &&
                        record.getDate().getYear() == now.getYear())
                .collect(Collectors.toList());
    }

    public List<FinancialRecord> getTodayRecords() {
        LocalDate today = LocalDate.now();
        return allRecords.stream()
                .filter(record -> record.getDate().equals(today))
                .collect(Collectors.toList());
    }

    public List<Expense> getFoodExpenses() {
        return allRecords.stream()
                .filter(record -> record instanceof Expense)
                .map(record -> (Expense) record)
                .filter(expense -> "Тамақ".equals(expense.getCategory()))
                .collect(Collectors.toList());
    }

    public void sortByDate() {
        allRecords.sort(Comparator.comparing(FinancialRecord::getDate));
    }

    public void sortByAmountDesc() {
        allRecords.sort((r1, r2) -> Double.compare(r2.getAmount(), r1.getAmount()));
    }

    //Getter
    public double getTotalIncome() {
        return allRecords.stream()
                .filter(record -> record instanceof Income)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return allRecords.stream()
                .filter(record -> record instanceof Expense)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public List<Expense> getExpensesByCategory(String category) {
        return allRecords.stream()
                .filter(record -> record instanceof Expense)
                .map(record -> (Expense) record)
                .filter(expense -> category.equals(expense.getCategory()))
                .collect(Collectors.toList());
    }
}
