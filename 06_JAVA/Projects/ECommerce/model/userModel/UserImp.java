package model.userModel;

public class UserImp implements User{
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    UserImp(String firstName,String lastName,String email,String password) {
        this.id = ++idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    @Override
    public String getEmail() {
        return this.email;
    }
    @Override
    public String getFirstName() {
        return this.firstName;
    }
    @Override
    public int getId() {
        return this.id;
    }
    @Override
    public String getLastName() {
        return this.lastName;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static void clearState() {
    idCounter = 0;
    }
}
