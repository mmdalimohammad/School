package repository.impl;

import data.Database;
import repository.AdminRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static data.Query.*;

public class AdminRepositoryImpl implements AdminRepository {
    private Database database = new Database();

    @Override
    public boolean login(String username, String password) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(ADMIN_USER_AND_PASS);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
}
