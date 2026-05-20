package org.projekt2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projekt2.config.DatabaseConnection;
import org.projekt2.config.SecurityUtil;
import org.projekt2.model.User;
import org.projekt2.service.UserService;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @BeforeEach
    void setup() {
        DatabaseConnection.init("postgres", "postgres");
    }

    @Test
    void shouldCreateUser() {

        UserService service = new UserService();
        User user = new User("admin", "password123");

        assertDoesNotThrow(() -> service.createUser(user));
    }

    @Test
    void shouldCreateSecondUser() {

        UserService service = new UserService();
        User user = new User("user2", "pass456");

        assertDoesNotThrow(() -> service.createUser(user));
    }

    @Test
    void shouldConnectToDatabase() throws Exception {

        Connection connection = DatabaseConnection.connect();

        assertNotNull(connection);
    }

    @Test
    void shouldHashPasswordCorrectly() {

        String password = "secret123";

        String hash = org.mindrot.jbcrypt.BCrypt.hashpw(
                password,
                org.mindrot.jbcrypt.BCrypt.gensalt()
        );

        assertTrue(
                org.mindrot.jbcrypt.BCrypt.checkpw(password, hash)
        );
    }

    @Test
    void shouldEncryptAndDecryptCredentials() throws Exception {

        String key = "1234567890123456";

        String encrypted = SecurityUtil.encrypt("password", key);
        String decrypted = SecurityUtil.decrypt(encrypted, key);

        assertEquals("password", decrypted);
    }
}