package model.employee;

public class Employee {
    int employeeId;
    String employeeName;
    String employeeBirthday;
    String employeeIdCard;
    Double employeeSalary;
    String employeePhone;
    String employeeEmail;
    String employeeAddress;
    int employeePositionId;
    int employeeEducationDegreeId;
    int employeeDivisionId;
    String employeeUserName;

    public Employee() {
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard,
                    Double employeeSalary, String employeePhone, String employeeEmail,
                    String employeeAddress, int employeePositionId, int employeeEducationDegreeId,
                    int employeeDivisionId, String employeeUserName) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePositionId = employeePositionId;
        this.employeeEducationDegreeId = employeeEducationDegreeId;
        this.employeeDivisionId = employeeDivisionId;
        this.employeeUserName = employeeUserName;
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int employeePositionId, int employeeEducationDegreeId, int employeeDivisionId, String employeeUserName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePositionId = employeePositionId;
        this.employeeEducationDegreeId = employeeEducationDegreeId;
        this.employeeDivisionId = employeeDivisionId;
        this.employeeUserName = employeeUserName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getEmployeePositionId() {
        return employeePositionId;
    }

    public void setEmployeePositionId(int employeePositionId) {
        this.employeePositionId = employeePositionId;
    }

    public int getEmployeeEducationDegreeId() {
        return employeeEducationDegreeId;
    }

    public void setEmployeeEducationDegreeId(int employeeEducationDegreeId) {
        this.employeeEducationDegreeId = employeeEducationDegreeId;
    }

    public int getEmployeeDivisionId() {
        return employeeDivisionId;
    }

    public void setEmployeeDivisionId(int employeeDivisionId) {
        this.employeeDivisionId = employeeDivisionId;
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }
}
