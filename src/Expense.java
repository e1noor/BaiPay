import java.time.LocalDate;

class Expense extends FinancialRecord implements Displayable {

    private String category;
    private String type;

    public Expense(double amount, LocalDate date, String description, String category, String type) {
        super(amount, date, description);
        this.category = category;
        this.type = type;
    }




    @Override
    public void display() {
        System.out.println("❌ ШЫҒЫН: " + amount + " ₸");
        System.out.println("   Санаты: " + category);
        System.out.println("   Түрі: " + type);
        System.out.println("   Күні: " + date);
        System.out.println("   Сипаттама: " + description);
        System.out.println("   --------------------");
    }

    @Override
    public String getShortInfo() {
        return "Шығын: " + amount;
    }

    @Override
    public String toString() {
        return String.format("Expense[amount=%.2f, date=%s, category=%s]", amount, date, category);
    }


    //Getter/Setter
    public String getCategory() { return this.category; }
    public void setCategory(String category) { this.category = category; }

    public String getType() { return this.type; }
    public void setType(String type) { this.type = type; }


}
