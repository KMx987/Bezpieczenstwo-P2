package org.projekt2.service;

import org.mindrot.jbcrypt.BCrypt;
import org.projekt2.config.DatabaseConnection;
import org.projekt2.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserService {

    public void createUser(User user) throws Exception {

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        Connection connection = DatabaseConnection.connect();

        String sql = "INSERT INTO users(username, password) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, hashedPassword);

        preparedStatement.executeUpdate();

        connection.close();
    }
}