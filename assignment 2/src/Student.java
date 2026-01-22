public class Student extends Person {
    private int StudentId;
    String major;

    public Student(String name, int age, int StudentId, String major){
        super(name, age);
        this.StudentId = StudentId;
        this.major = major;
    }

    public int getStudentId(){
        return this.StudentId;
    }

    public String getMajor(){
        return this.major;
    }

    public void setStudentId(int StudentId){
        this.StudentId = StudentId;
    }

    public void setMajor(String major){
        this.major = major;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Student ID: " + StudentId);
        System.out.println("Major: " + major);
        System.out.println("--------------------");
    }

}
