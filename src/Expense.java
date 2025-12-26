
class Expense extends FinancialRecord implements Displayable {
    private double amount;
    private String category;
    private String type;

    public Expense(double amount, String category, String type) {
        this.amount = amount;
        this.category = category;
        this.type = type;
    }


    public void printExpenseDetails() {
        System.out.println("Шығын категориясы: " + this.category);
        System.out.println("Шығын сомасы: " + this.amount);
    }


    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void display() {

    }

    @Override
    public String getShortInfo() {
        return "Шығын: " + amount;
    }
}
