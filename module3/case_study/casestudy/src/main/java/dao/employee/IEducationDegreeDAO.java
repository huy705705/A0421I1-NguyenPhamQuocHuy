package dao.employee;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeDAO {
    public List<EducationDegree> selectAllEducationDegrees();
}
