package main.usermanagement;

public class PowerUser extends User {
    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Power");
    }

    @Override
    public void displayPrivileges() {
        System.out.println("Power User: Read and write access to User.csv");
    }
}
