package repository.impl;


import repository.AdminRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static data.Database.*;

import static data.Query.*;

public class AdminRepositoryImpl implements AdminRepository {

    @Override
    public boolean login(String username, String password) throws SQLException {
        PreparedStatement pst =getPreparedStatement(ADMIN_USER_AND_PASS);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
}
