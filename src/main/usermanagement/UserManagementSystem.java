package main.usermanagement;

import java.io.*;
import java.util.*;

public class UserManagementSystem {
    private Map<String, User> users = new HashMap<>();
    private User currentUser;

    public void loadUsers() throws IOException {
        BufferedReader userReader = new BufferedReader(new FileReader("src/main/resources/User.csv"));
        BufferedReader adminReader = new BufferedReader(new FileReader("src/main/resources/Admin.csv"));

        String line;
        while ((line = userReader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals("UserID")) continue;  // Skip header
            addUserByType(data);
        }
        userReader.close();

        while ((line = adminReader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals("UserID")) continue;  // Skip header
            users.put(data[1], new AdminUser(data[0], data[1], data[2], data[3]));
        }
        adminReader.close();
    }

    private void addUserByType(String[] data) {
        User user = switch (data[4]) {
            case "Regular" -> new RegularUser(data[0], data[1], data[2], data[3]);
            case "Power" -> new PowerUser(data[0], data[1], data[2], data[3]);
            default -> null;
        };
        if (user != null) users.put(data[1], user);
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Authentication successful for user: " + username);
            return true;
        } else {
            System.out.println("Authentication failed.");
            return false;
        }
    }

    public void displayUserPrivileges() {
        if (currentUser != null) {
            currentUser.displayPrivileges();
        } else {
            System.out.println("No user authenticated.");
        }
    }
}
