package herokuapp;


public class Person {
    private final String lastName;
    private final String firstName;
    private final String email;
    private final String website;
    private final float due;

    public Person(String lastName, String firstName, String email, String website, float due) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.website = website;
        this.due = due;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public float getDue() {
        return due;
    }

    public String getFullName(){
        return String.format("%s %s",firstName,lastName);
    }
}
