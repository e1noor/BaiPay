class Investment {
    private String assetName;
    private double amountInvested;
    private double currentValue;

    public Investment(String assetName, double amountInvested, double currentValue) {
        this.assetName = assetName;
        this.amountInvested = amountInvested;
        this.currentValue = currentValue;
    }


    public double getProfit() {
        double profit = this.currentValue - this.amountInvested;
        return profit;
    }


    public String getAssetName() {
        return this.assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public double getAmountInvested() {
        return this.amountInvested;
    }

    public void setAmountInvested(double amountInvested) {
        this.amountInvested = amountInvested;
    }


    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}
