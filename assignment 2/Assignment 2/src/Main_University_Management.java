import java.util.concurrent.SubmissionPublisher;

public class Main_University_Management {
    public static void main(String[] args) {

        Student Elnur = new Student("Elnur", 17, 254253, "SE");
        Professor Khaimuldin = new Professor("Khaimuldin", 35, 1, "IT");
        Staff Beka = new Staff("Beka", 17, 2, "president");


        Person person = new Person("PersonName", 25);

        Elnur.displayInfo();
        Khaimuldin.displayInfo();
        Beka.displayInfo();


    }
}