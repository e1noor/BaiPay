public class FullTimeEmployee extends Person_2 implements Employee {
    private double salary;


    public FullTimeEmployee(String name, int age, double salary){
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void work(){
        System.out.println("Full-time employee working");
    }

    @Override
    public double calculateSalary(){
        return salary;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}
