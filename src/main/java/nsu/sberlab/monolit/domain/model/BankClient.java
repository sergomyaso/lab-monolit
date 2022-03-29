package nsu.sberlab.monolit.domain.model;

public class BankClient {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_SECOND_NAME = "secondName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_PASSPORT = "passport";


    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String passport;

    public BankClient(int id, String firstName, String secondName, String lastName, String passport) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
