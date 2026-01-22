public class Professor extends Person {
    private int professorId;
    private String department;

    public Professor(String name, int age, int professorId, String department){
        super(name, age);
        this.professorId = professorId;
        this.department = department;
    }

    public int getProfessorId(){ return this.professorId; }

    public String getDepartment(){ return this.department; }

    public void setProfessorId(int professorId){ this.professorId = professorId; }

    public void setDepartment(String department){ this.department = department; }


    @Override
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Professor_ID: "+professorId);
        System.out.println("Department: "+department);
    }

}
