public class Intern extends Person_2 implements Employee {
    private double stipend;

    public Intern(String name, int age, double stipend){
        super(name, age);
        this.stipend = stipend;
    }

    @Override
    public void work(){
        System.out.println("Intern working");
    }

    @Override
    public double calculateSalary(){
        return stipend;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("stipend: " + stipend);
    }
}
