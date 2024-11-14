package main.usermanagement;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserManagementSystem ums = new UserManagementSystem();

        try {
            ums.loadUsers();
        } catch (IOException e) {
            System.out.println("Error loading users.");
            e.printStackTrace();
        }

        if (ums.authenticate("johndoe", "pass123")) {
            ums.displayUserPrivileges();
        }

        if (ums.authenticate("adminuser", "adminpass")) {
            ums.displayUserPrivileges();
        }
    }
}
