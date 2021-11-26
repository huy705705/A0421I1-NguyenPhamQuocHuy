package dao.employee;

import model.employee.Role;
import model.employee.UserRole;

import java.util.List;

public interface IUserRoleDAO {
    public List<UserRole> selectAllUserRoles();

}
