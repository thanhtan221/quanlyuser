package service;

import model.CafeShop;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CafeShopService implements ICafeShopService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/module3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0379825939";

    private static final String INSERT_CAFE_SQL = "INSERT INTO cafeshop (Drinks,price,quantity) VALUES (?, ?, ?);";
    private static final String SELECT_CAFE_BY_ID = "select Drinks,price,quantity from cafeshop where id =?";
    private static final String SELECT_ALL_CAFE = "select * from cafeshop;";
    private static final String UPDATE_CAFE_SQL = "update cafeshop set Drinks = ?, price=? ,quantity= ? where id = ?;";

    public CafeShopService() {
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

    public void insertcafeshop(CafeShop cafeShop) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAFE_SQL)) {
            preparedStatement.setString(1, cafeShop.getDrinks());
            preparedStatement.setInt(2, cafeShop.getPrice());
            preparedStatement.setInt(3, cafeShop.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public CafeShop selectcafeshop(int id) {
        CafeShop cafeShop = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CAFE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Drinks");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("quantity");
                cafeShop = new CafeShop(name, price, quantity);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return cafeShop;
    }

    public List<CafeShop> selectAllcafeshop() {
        List<CafeShop> cafeShops = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CAFE);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String Drinks = rs.getString("Drinks");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int total = price * quantity;
                cafeShops.add(new CafeShop(id, Drinks, price, quantity, total));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return cafeShops;
    }

    public boolean updatecafeshop(CafeShop cafeShop) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CAFE_SQL);) {
            statement.setString(1, cafeShop.getDrinks());
            statement.setInt(2, cafeShop.getPrice());
            statement.setInt(3, cafeShop.getQuantity());
            statement.setInt(4, cafeShop.getId());
            rowUpdated = statement.executeUpdate() > 0;
            System.out.println(statement);
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

}
