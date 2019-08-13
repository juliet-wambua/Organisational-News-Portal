package dao;

import models.Employees;
import models.Departments;
import org.junit.Test;
import org.sql2o.Connection;
import org.junit.After;
import java.util.Arrays;
import org.junit.Before;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oEmployeesDaoTest {
    private static Sql2oEmployeesDao employeesDao;
    private  static Connection conn;
    private static Sql2oDepartmentsDao departmentsDao;

    @Before
    public void setUp() throws Exception {
        String connectingString= "jdbc:postgresql://localhost:5432/newsportal_test";
        Sql2o sql2o = new Sql2o(connectingString,"moringaschool","1543");
        employeesDao = new Sql2oEmployeesDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addAndSetId() {
        Employees testEmployee = setupEmployees();
        employeesDao.add(testEmployee);
        int empId= testEmployee.getId();
        assertEquals(testEmployee.getId(),empId);
    }
    @Test
    public void getAllEmployees(){
        Employees testEmployees = setupEmployees();
        employeesDao.add(testEmployees);
        Employees employees1 = setupEmployees();
        employeesDao.add(employees1);
        assertTrue(employeesDao.getAllEmployees().contains(testEmployees));
        assertTrue(employeesDao.getAllEmployees().contains(employees1));
    }
    @Test
    public void clearAll() {
        Employees testEmployees = setupEmployees();
        employeesDao.add(testEmployees);
        employeesDao.clearAll();
        assertEquals(0,employeesDao.getAllEmployees().size());
    }
    @Test
    public void addEmployeeToDepartment() {
        Employees testEmployees = setupEmployees();
        employeesDao.add(testEmployees);

        Departments testDepartments = setupDepartments();
        departmentsDao.add(testDepartments);
        Departments department1 = setupDepartments2();
        departmentsDao.add(department1);

        employeesDao.addEmpToDepartments(testEmployees,testDepartments);
        employeesDao.addEmpToDepartments(testEmployees,department1);
        Departments[] addedEmToDepartment = {testDepartments,department1};
        assertEquals(Arrays.asList(addedEmToDepartment),employeesDao.getAllDptBelongingToEmployees(testEmployees.getId()));
    }


    @Test
    public void findById() {
        Employees testEmployee = setupEmployees();
        employeesDao.add(testEmployee);
        Employees employee2 = employeesDao.findById(testEmployee.getId());
        assertEquals(employee2,testEmployee);
    }
    public Employees setupEmployees(){
        return new Employees("mimy", "patrol", "Directs","soldier");
    }
    public Departments setupDepartments(){ return new Departments("sales", "marketing", 40);}
    public Departments setupDepartments2(){ return new Departments("kitchen", "cook", 10);}
}