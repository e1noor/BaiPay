public class Main_university {
    public static void main(String[] args) {
        Person Baxa = new Person("Baxa", 17);
        Professor Askar = new Professor("Askar", 33, 101, "SE");
        Staff ccc = new Staff("ccc", 32,101,"president");


        Person person = new Person("PersonName", 25);

        Baxa.displayInfo();
        Askar.displayInfo();
        ccc.displayInfo();
        person.displayInfo();
    }
}