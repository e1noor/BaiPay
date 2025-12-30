import java.time.LocalDate;

class Investment extends FinancialRecord implements Displayable {
    private String assetName;
    private double amountInvested;
    private double currentValue;

    public Investment(String assetName, double amountInvested, double currentValue, LocalDate date, String description) {
        super(amountInvested, date, description);
        this.assetName = assetName;
        this.amountInvested = amountInvested;
        this.currentValue = currentValue;
    }

    public double getProfit() {
        return currentValue - amountInvested;
    }

    public double getProfitPercentage() {
        return (getProfit() / amountInvested) * 100;
    }

    @Override
    public void display() {
        System.out.println("📈 ИНВЕСТИЦИЯ: " + assetName);
        System.out.println("   Бастапқы салым: " + amountInvested + " ₸");
        System.out.println("   Ағымдағы құны: " + currentValue + " ₸");
        System.out.println("   Пайда: " + getProfit() + " ₸ (" +
                String.format("%.2f", getProfitPercentage()) + "%)");
        System.out.println("   Күні: " + date);
        System.out.println("   --------------------");
    }

    @Override
    public String getShortInfo() {
        return String.format("Инвестиция: %s (пайда: %.2f ₸)", assetName, getProfit());
    }

    @Override
    public String toString() {
        return String.format("Investment[asset=%s, invested=%.2f, current=%.2f, profit=%.2f]", assetName, amountInvested, currentValue, getProfit());
    }



    // equals() және hashCode() қосу (міндетті емес, бірақ жақсы)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Investment)) return false;
        Investment other = (Investment) obj;
        return assetName.equals(other.assetName) &&
                Double.compare(amountInvested, other.amountInvested) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(assetName, amountInvested);
    }

    // Getter/Setter
    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }

    public double getAmountInvested() { return amountInvested; }
    public void setAmountInvested(double amountInvested) {
        this.amountInvested = amountInvested;
        super.setAmount(amountInvested);
    }

    public double getCurrentValue() { return currentValue; } // БҰЛ ӘДІСТІ ҚОСУ!
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}