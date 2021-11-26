package dao.employee;

import model.employee.Division;
import model.employee.EducationDegree;

import java.util.List;

public interface IDivisionDAO {
    public List<Division> selectAllDivisions();

}
