package main.usermanagement;

public class AdminUser extends User {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Admin");
    }

    @Override
    public void displayPrivileges() {
        System.out.println("Admin User: Full access to User.csv and Admin.csv");
    }

    public void renameFile(String oldName, String newName) {
        System.out.println("Renaming file " + oldName + " to " + newName);
    }
}
