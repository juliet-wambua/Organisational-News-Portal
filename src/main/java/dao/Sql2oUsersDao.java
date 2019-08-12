package dao;
import DB.DB;
import Models.Users;
import org.h2.engine.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements UsersDao {

    private final Sql2o sql2o;
    public Sql2oUsersDao(Sql2o sql2o){this.sql2o = sql2o;}

    @Override
    public void add(Users user) {
        String sql = "INSERT INTO users (username, address, phone, email, departmentid, position, roles) VALUES (:userName, :address, :phone, :email, :departmentId, :position, :roles);";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Users> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public List<Users> getAllUsersByDepartment(int departmentId) {
        String sql = "SELECT * FROM users WHERE departmentId=:departmentId";
        try (Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public Users findById(int id) {
        String sql = "SELECT * FROM users WHERE id=:id;";
        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
