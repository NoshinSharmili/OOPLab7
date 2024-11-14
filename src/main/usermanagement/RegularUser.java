package main.usermanagement;

public class RegularUser extends User {
    public RegularUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Regular");
    }

    @Override
    public void displayPrivileges() {
        System.out.println("Regular User: Read-only access to User.csv");
    }
}
