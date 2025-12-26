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