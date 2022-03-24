package dao;

import model.Role;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0379825939";

    private static final String INSERT_USERS_SQL = "INSERT INTO user (name, password, phone,address,city,role) VALUES (?, ?, ?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "select name,password,phone,address,city,role from user where id =?";
    private static final String SELECT_ALL_USERS = "select * from user;";
    private static final String UPDATE_USERS_SQL = "update user set name = ?,password= ?,phone=?, address =?,city=? where id = ?;";
    private static final String Account_USER_SQL = "SELECT * FROM user where name=? and password =?;";
    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setString(6, String.valueOf(user.getRole()));
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                Role role = Role.valueOf(rs.getString("role"));
                user = new User(id, name, password, phone, address, city,role);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                Role role = Role.valueOf(rs.getString("role"));
                users.add(new User(id, name, password, phone, address, city, role));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getCity());
            statement.setInt(6,user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public User checkloginuser(String name, String password) {
        User user ;
        try(Connection connection =getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Account_USER_SQL)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                 user = new User(rs.getString(2),rs.getString(3),Role.valueOf(rs.getString(7)));
                return user;
            }
        } catch (Exception e) {
    e.printStackTrace();
        }
        return null;
    }

}