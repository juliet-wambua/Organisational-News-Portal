package dao;

import Models.Departments;

import java.util.List;

public interface DepartmentDao {

    //create
    void add(Departments department);

    //read
    List<Departments>getAll();
    Departments findById(int departmentId);

    //update
    void update(String departmentName, String departmentDescription, int noOfEmployees);

    //delete
    void deleteById(int id);
    void clearAll();

}
