package data;

import java.sql.*;

public class Database {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/school";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "12345";



    public static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

//    public Statement getSqlStatement() throws SQLException {
//        return this.getDatabaseConnection().createStatement();
//    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getDatabaseConnection().prepareStatement(sql);
    }
}
