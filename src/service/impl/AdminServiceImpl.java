package service.impl;

import repository.AdminRepository;
import service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminRepository ar;

    public AdminServiceImpl(AdminRepository ar) {
        this.ar = ar;
    }

    @Override
    public boolean login(String username, String password) throws SQLException {
        if (ar.login(username, password)) {
            return true;
        }else {
            return false;
        }
    }
}
