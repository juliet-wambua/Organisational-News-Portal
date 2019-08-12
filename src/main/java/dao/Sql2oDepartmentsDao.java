package dao;

import Models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oDepartmentsDao {
private final Sql2o sql2o;
public Sql2oDepartmentsDao(Sql2o){
    this.sql2o = sql2o;
}

@Override
    public void add(Departments departments){
    String sql = "INSERT INTO departments(departmentName, :departmentDescription, :noOfEmployees) VALUES (:departmentName, :departmentDescription, :noOfEmployees)";
    try(Connection con = sql2o = sql2o.open()) {
        int id = (int) con.createQuery(sql, true)
                .bind(departments)
                .executeUpdate()
                .getKey();
       departments.setId(id);
    }
}
}
