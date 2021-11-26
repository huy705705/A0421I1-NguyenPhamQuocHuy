package dao.employee;

import model.employee.PositionEmployee;

import java.util.List;

public interface IPositionEmployeeDAO {
    public List<PositionEmployee> selectAllPositionEmployees();

}
