import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    System.out.println("BayPay - Assignment 2\n");

    BudgetManager manager = new BudgetManager();


    LocalDate today = LocalDate.now();
    LocalDate yesterday = today.minusDays(1);
    LocalDate lastWeek = today.minusDays(7);



    Income monthlySalary = new Income(600000.0, today, "Негізгі жалақы", "Жұмыс", "ACTUAL");
    Income freelanceIncome = new Income(150000.0, yesterday, "Фриланс", "Фриланс", "PASSIVE");


    Expense foodExpense = new Expense(70000.0, today, "Тамақ азығы", "Тамақ", "ACTUAL");
    Expense transportExpense = new Expense(25000.0, lastWeek, "Такси", "Көлік", "ACTUAL");
    Expense rentExpense = new Expense(120000.0, today, "Пәтер жалға алу", "Тұрғын үй", "FIXED");

    Budget myBudget = new Budget(200000);


    Investment myCrypto = new Investment("Apple shares", 103670, 140432, today, "Акцияға салым");

    manager.addIncome(monthlySalary);
    manager.addIncome(freelanceIncome);
    manager.addExpense(foodExpense);
    manager.addExpense(transportExpense);
    manager.addExpense(rentExpense);

    System.out.println("=== ПОЛИМОРФИЗМ (display()) ===");
    for (FinancialRecord record : manager.getAllRecords()) {
      record.display();
    }

    System.out.println("\n=== СҮЗГІЛЕУ ===");
    System.out.println("Тамақ шығыстары:");
    for (Expense exp : manager.getFoodExpenses()) {
      System.out.println("  - " + exp.getShortInfo());
    }

    System.out.println("\nБүгінгі операциялар:");
    for (FinancialRecord record : manager.getTodayRecords()) {
      System.out.println("  - " + record.getDescription() + ": " + record.getAmount());
    }

    System.out.println("\n=== СҰРЫПТАУ (сома бойынша) ===");
    manager.sortByAmountDesc();
    for (FinancialRecord record : manager.getAllRecords()) {
      System.out.println("  - " + record.getAmount() + " | " + record.getDescription());
    }

    System.out.println("\n=== СТАТИСТИКА ===");
    System.out.println("Жалпы кіріс: " + manager.getTotalIncome() + " ₸");
    System.out.println("Жалпы шығын: " + manager.getTotalExpense() + " ₸");
    System.out.println("Таза табыс: " + (manager.getTotalIncome() - manager.getTotalExpense()) + " ₸");

    System.out.println("\n=== toString() ===");
    System.out.println(monthlySalary);          // toString() қажет емес
    System.out.println(foodExpense);            // toString() қажет емес
    System.out.println(myCrypto);               // toString() қажет емес

    System.out.println("\n=== equals()/hashCode() ===");
    User user1 = new User(101, "Алихан");
    User user2 = new User(101, "Алихан");
    User user3 = new User(102, "Диана");

    System.out.println("user1.equals(user2): " + user1.equals(user2));
    System.out.println("user1.equals(user3): " + user1.equals(user3));
    System.out.println("user1 hashCode: " + user1.hashCode());
    System.out.println("user2 hashCode: " + user2.hashCode());


    System.out.println("\n=== БЮДЖЕТ ТЕКСЕРУ ===");
    double totalExpenses = manager.getTotalExpense();
    System.out.println("Бюджет шегі: " + myBudget.getLimit() + " ₸");
    System.out.println("Жалпы шығын: " + totalExpenses + " ₸");

    if (myBudget.isOverLimit(totalExpenses)) {
      System.out.println("⚠️ ЕСКЕРТУ: Сіз бюджеттен асып кеттіңіз!");
    } else {
      System.out.println("✅ КЕРЕМЕТ: Бюджет сақталды.");
    }


    System.out.println("\n=== ИНВЕСТИЦИЯ ===");
    myCrypto.display();
    System.out.println("Инвестиция пайдасы: " + myCrypto.getProfit() + " ₸");
  }
}