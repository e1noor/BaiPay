
class User {

  private int id;
  private String name;


  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public void showProfile() {
    System.out.println("--- Пайдаланушы мәліметі ---");
    System.out.println("ID нөмірі: " + this.id);
    System.out.println("Есімі: " + this.name);
    System.out.println("----------------------------");
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}


class Income {
  private double amount;
  private String type;

  public Income(double amount, String type) {
    this.amount = amount;
    this.type = type;
  }


  public void applyIncome() {
    System.out.println("Кіріс операциясы орындалды.");
    System.out.println("Мөлшері: " + this.amount + " теңге");
    System.out.println("Түрі: " + this.type);
  }


  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }
}


class Expense {
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
}


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


  public double getLimit() {
    return this.limit;
  }

  public void setLimit(double limit) {
    this.limit = limit;
  }
}


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


public class Main {
  public static void main(String[] args) {
    System.out.println("BayPay\n");


    User myUser = new User(101, "Алихан");
    User anotherUser = new User(102, "Диана");


    User duplicateUser = new User(101, "Алихан");

    Income monthlySalary = new Income(600000.0, "ACTUAL");
    Expense foodExpense = new Expense(70000.0, "Тамақ", "ACTUAL");
    Budget myBudget = new Budget(200000);
    Investment myCrypto = new Investment("Apple shares", 103670, 140432);


    myUser.showProfile();
    monthlySalary.applyIncome();

    System.out.println("\n--- Шығын туралы ақпарат ---");
    foodExpense.printExpenseDetails();


    System.out.println("\n--- Есептеулер ---");


    double profit = myCrypto.getProfit();
    System.out.println("Инвестиция (" + myCrypto.getAssetName() + ") пайдасы: " + profit + " теңге");


    System.out.println("Бюджет шегі: " + myBudget.getLimit());
    System.out.println("Жұмсалған ақша: " + foodExpense.getAmount());

    boolean isOver = myBudget.isOverLimit(foodExpense.getAmount());
    if (isOver) {
      System.out.println("ЕСКЕРТУ: Сіз бюджеттен асып кеттіңіз!");
    } else {
      System.out.println("КЕРЕМЕТ: Бюджет сақталды.");
    }


    System.out.println("\n--- Объектілерді салыстыру ---");


    if (myUser.getId() == anotherUser.getId()) {
      System.out.println("1. myUser мен anotherUser - БІР адам.");
    } else {
      System.out.println("1. myUser мен anotherUser - ӘРТҮРЛІ адамдар.");
    }


    if (myUser.getId() == duplicateUser.getId()) {
      System.out.println("2. myUser мен duplicateUser - ID бойынша БІРДЕЙ.");
    } else {
      System.out.println("2. myUser мен duplicateUser - ID бойынша ӘРТҮРЛІ.");
    }
  }
}