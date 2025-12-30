import java.time.LocalDate;

public abstract class FinancialRecord {
    protected double amount;
    protected final LocalDate date;
    protected String description;

    public FinancialRecord(double amount, final LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    //Getter/Setter
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public abstract void display();

}
