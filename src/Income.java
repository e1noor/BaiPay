import java.time.LocalDate;

class Income extends FinancialRecord implements Displayable {
    private String source;
    private String type;

    public Income(double amount, LocalDate date, String description, String source, String type) {
        super(amount, date, description);  // ← ӘКЕСІНІҢ конструкторын шақыру
        this.source = source;
        this.type = type;
    }


    public void applyIncome() {
        System.out.println("Кіріс операциясы орындалды.");
        System.out.println("Мөлшері: " + this.amount + " теңге");
        System.out.println("Түрі: " + this.type);
    }




    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void display() {
        System.out.println("Кіріс: " + amount + " | Көзі: " + source +
                " | Күні: " + date + " | Сипаттама: " + description);
    }

    @Override
    public String getShortInfo() {
        return "Кіріс: " + amount;
    }

    @Override
    public String toString() {
        return String.format("Income[amount=%.2f, date=%s, source=%s]",
                amount, date, source);
    }
}
