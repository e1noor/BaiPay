public class Student extends Person {
    private int studentId;
    private String major;

    public Student(String name, int age, int studentId, String major){
        super(name, age);
        this.studentId = studentId;
        this.major = major;
    }

    public int getStudentId(){ return this.studentId; }

    public String getMajor(){ return this.major; }

    public void setStudentId(int studentId){ this.studentId = studentId; }

    public void setMajor(String major){ this.major = major; }

    @Override
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student_ID: "+studentId);
        System.out.println("Major: "+major);

    }
}
