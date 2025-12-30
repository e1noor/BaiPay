
class Budget {
    private double limit;

    public Budget(double limit) {
        this.limit = limit;
    }


    public boolean isOverLimit(double totalExpense) {
        if (totalExpense > this.limit) {
            return true;
        } else {
            return false;
        }
    }


    //Getter/Setter
    public double getLimit() {
        return this.limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
}
