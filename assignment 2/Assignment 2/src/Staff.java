public class Staff extends Person {
    private int staffId;
    private String role;

    public Staff(String name, int age, int staffId, String role){
        super(name, age);
        this.staffId = staffId;
        this.role = role;
    }


    public int getStaffId(){ return this.staffId; }

    public String getRole(){ return this.role; }

    public void setStaffId(int staffId){ this.staffId = staffId; }

    public void setRole(String role){ this.role = role; }

    @Override
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Staff_ID: "+staffId);
        System.out.println("Role: "+role);
    }



}
