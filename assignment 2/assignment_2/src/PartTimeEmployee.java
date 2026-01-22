public class PartTimeEmployee extends Person_2 implements Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int age, double hourlyRate, int hoursWorked){
        super(name, age);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void work(){
        System.out.println("Part-time employee working");
    }

    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("hourlyRate: "+hourlyRate);
        System.out.println("hoursWorked: "+hoursWorked);
    }
}
