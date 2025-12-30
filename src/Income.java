import java.time.LocalDate;
import java.util.Objects;

class Income extends FinancialRecord implements Displayable {
    private String source;
    private String type;


    public Income(double amount, LocalDate date, String description, String source, String type) {
        super(amount, date, description);
        this.source = source;
        this.type = type;
    }

    public void applyIncome() {
        System.out.println("Кіріс операциясы орындалды: " + amount + " ₸");
    }

    @Override
    public void display() {
        System.out.println("✅ КІРІС: " + amount + " ₸");
        System.out.println("   Көзі: " + source);
        System.out.println("   Түрі: " + type);
        System.out.println("   Күні: " + date);
        System.out.println("   Сипаттама: " + description);
        System.out.println("   --------------------");
    }

    @Override
    public String getShortInfo() {
        return String.format("Кіріс: %.2f ₸ (%s)", amount, source);
    }

    @Override
    public String toString() {
        return String.format("Income[amount=%.2f, date=%s, source=%s]", amount, date, source);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Income)) return false;
        Income other = (Income) obj;
        return Double.compare(other.amount, amount) == 0 && date.equals(other.date) && source.equals(other.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date, source);
    }

    // Getter/Setter
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}