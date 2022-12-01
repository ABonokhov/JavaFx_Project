package sample;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName; //строка подключения к БД
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(String user_name, String user_password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" + Const.USER_NAME + ", " +
                Const.USER_PASSWORD + ") " + "VALUES (?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, user_password);
        preparedStatement.executeUpdate();   // добавление пользователя в бд

    }

    public void signUpIncome(float income_sum, String income_com) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.INCOME_TABLE + " (" + Const.INCOME_SUM + ", " +
                Const.INCOME_COM + ") " + "VALUES (?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setFloat(1, income_sum);
        preparedStatement.setString(2, income_com);
        preparedStatement.executeUpdate();  // добавление данных о доходах в бд


    }

    public void signUpExpenses(float expenses_sum, String expenses_com) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.EXPENSES_TABLE + " (" + Const.EXPENSES_SUM + ", " +
                Const.EXPENSES_COM + ") " + "VALUES (?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setFloat(1, expenses_sum);
        preparedStatement.setString(2, expenses_com);
        preparedStatement.executeUpdate(); // добавление данных о расходах в бд

    }

    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException { // метод для получения данных уже из БД
        ResultSet resultset = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_NAME + "=? AND " + Const.USER_PASSWORD + "=?"; // sql запрос для выборки из бд, где логин и пароль корректны
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, user.getUser_name()); // добавляем параметры для сравнения
        preparedStatement.setString(2, user.getUser_password());
        resultset = preparedStatement.executeQuery(); // для получения данных из бд
        return resultset;
    }
}

