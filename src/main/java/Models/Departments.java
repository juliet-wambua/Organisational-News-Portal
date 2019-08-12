package Models;

public class Departments {
    private String departmentName;
    private String departmentDescription;
    private int noOfEmployees;
    private int id;

    public Departments(String departmentName, String departmentDescription, int noOfEmployees){
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.noOfEmployees = noOfEmployees;

    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }
}
