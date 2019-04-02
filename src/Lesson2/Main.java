package Lesson2;

import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            createDB();
            insertEmployee("Homer", 1000);
            insertEmployee("Mr. Berns", 100000);
            insertEmployee("John Smith", 2000);
            deleteEmployeeById(2);
            selectAllTable();
            getMetaData();
            dropTable("employees");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - удаляет
    // DROP - удаляет таблицу
    // TRUNCATE - удаляет (транзакция)

    private static void dropTable(String name) throws SQLException {
        int res = stmt.executeUpdate("DROP TABLE IF EXISTS " + name);
        System.out.println(res);
    }

    private static void deleteEmployeeById(int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM employees where id = " + id);
    }

    private static void createDB() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employees " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "salary INTEGER)");
    }

    private static void selectAllTable() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees where id > 0");
        while(rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
    }

    private static void getMetaData() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees where id > 0");
        ResultSetMetaData rsmt = rs.getMetaData();

        for (int i = 1; i < rsmt.getColumnCount(); i++) {
            System.out.println(rsmt.getColumnName(i) + ", type: " + rsmt.getColumnType(i) + ",  label:" + rsmt.getColumnLabel(i));
        }
    }

    private static void insertEmployee(String name, int salary) throws SQLException {
        int res = stmt.executeUpdate("INSERT INTO employees (name, salary)\n" + "values ('" + name + "', " + salary + ")");
        System.out.println(res);
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        //DriverManager – это синглтон, который содержит информацию о всех зарегистрированных драйверах.
        // Метод getConnection на основании параметра URL находит java.sql.Driver соответствующей базы данных
        // и вызывает у него метод connect.
        connection = DriverManager.getConnection("jdbc:sqlite:userDB.db");
        stmt = connection.createStatement();
    }

    private static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
