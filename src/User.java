import java.util.Objects;

class User {
    private final int id;
    private String name;

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public void showProfile() {
        System.out.println("--- Пайдаланушы мәліметі ---");
        System.out.println("ID нөмірі: " + this.id);
        System.out.println("Есімі: " + this.name);
        System.out.println("----------------------------");
    }


    @Override
    public String toString() {
        return "Пайдаланушы #" + id + ": " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Getter/Setter
    public int getId() { return this.id; }


    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

}