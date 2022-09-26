package Logic.Models;

public class Member {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private long age;
    private boolean isStaff;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public long getAge() { return age; }
    public void setAge(long value) { this.age = value; }

    public boolean getIsStaff() { return isStaff; }
    public void setIsStaff(boolean value) { this.isStaff = value; }
}

