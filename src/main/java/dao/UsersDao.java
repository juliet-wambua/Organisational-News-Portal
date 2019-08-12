package dao;

import org.h2.engine.User;

import java.util.List;

public interface UserDao {

    //create
    void add(User user);

    //read
    List<User> getAll();
    List<User> getAllUsersForADepartment(int id);
    User findById(int id);

    //update
    void update(String userName, String userAddress, int userMobIleNo,String userEmail, String position, int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();
}
