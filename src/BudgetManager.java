import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<FinancialRecord> allRecords = new ArrayList<>();

    public void addIncome(Income income) {
        allRecords.add(income);
    }

    public void addExpense(Expense expense) {
        allRecords.add(expense);
    }

    public List<FinancialRecord> getThisMonthRecords() {

    }

    public List<Expense> getFoodExpenses() {

    }

    public void sortByDate() {
        // Күні бойынша сұрыптайды (ескіден жаңаға)
    }

    public void sortByAmountDesc() {
        // Сомасы бойынша кемімелі тәртіпте
    }

    // 5. СТАТИСТИКА
    public double getTotalIncome() {
        // Барлық кірістердің қосындысы
    }

    public double getTotalExpense() {
        // Барлық шығыстардың қосындысы
    }

}
