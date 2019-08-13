package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {



    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDepartmentNameReturnsCorrectName() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals("Sales", testDepartments.getDpt_name());
    }

    @Test
    public void getDepartmentDescriptionReturnsCorrectDescription() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals("marketing", testDepartments.getDpt_description());
    }

    @Test
    public void getDepartmentEmployeesNumbersReturnsCorrectDescription() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals(40, testDepartments.getDpt_empNo());
    }
    @Test
    public void setEmployeesNumberCorrectNumber(){
        Departments testDepartments = setupDepartments();
        testDepartments.setDpt_empNo(12);
        assertNotEquals(10, testDepartments.getDpt_empNo());

    }
    @Test
    public void setDptNameCorrectName(){
        Departments testDepartments = setupDepartments();
        testDepartments.setDpt_name("sales");
        assertNotEquals("kitchen", testDepartments.getDpt_name());

    }
    @Test
    public void setDescriptionCorrectDescription(){
        Departments testDepartments = setupDepartments();
        testDepartments.setDpt_description("marketing");
        assertNotEquals("cook", testDepartments.getDpt_description());

    }
    public Departments setupDepartments() {
        return new Departments("sales", "marketing", 12);
    }

}