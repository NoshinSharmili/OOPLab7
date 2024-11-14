package main.usermanagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.IOException;

class UserManagementSystemTest {

    private UserManagementSystem ums;

    @BeforeEach
    void setUp() {
        ums = new UserManagementSystem();
        try {
            ums.loadUsers();
        } catch (IOException e) {
            fail("Could not load users. Exception: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test successful authentication")
    void testAuthenticationSuccess() {
        assertTrue(ums.authenticate("noshin", "pass123"),
                "Authentication should succeed for noshin with correct password.");
    }

    @Test
    @DisplayName("Test failed authentication with incorrect password")
    void testAuthenticationFailure() {
        assertFalse(ums.authenticate("noshin", "wrongpass"),
                "Authentication should fail for noshin with incorrect password.");
    }

    @Test
    @DisplayName("Test display of privileges for authenticated user")
    void testDisplayUserPrivileges() {
        ums.authenticate("noshin", "pass123");
        assertDoesNotThrow(() -> ums.displayUserPrivileges(),
                "Display privileges should not throw an exception for authenticated user.");
    }

    @Test
    @DisplayName("Test admin user authentication and privilege display")
    void testAdminPrivileges() {
        assertTrue(ums.authenticate("adminuser", "adminpass"),
                "Authentication should succeed for adminuser with correct password.");
        ums.displayUserPrivileges();
        // You might want to capture the output and verify it matches expected privileges for an admin.
    }
}
