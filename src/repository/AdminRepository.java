package repository;

import java.sql.SQLException;

public interface AdminRepository {
    boolean login(String username, String password) throws SQLException;
}
