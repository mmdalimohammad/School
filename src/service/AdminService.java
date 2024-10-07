package service;

import java.sql.SQLException;

public interface AdminService {
    boolean login(String username, String password) throws SQLException;
}
