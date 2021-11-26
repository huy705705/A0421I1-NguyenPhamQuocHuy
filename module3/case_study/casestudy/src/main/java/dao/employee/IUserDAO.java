package dao.employee;

import model.employee.Role;
import model.employee.User;

import java.util.List;

public interface IUserDAO {
    public List<User> selectAllUsers();

}
