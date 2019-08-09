package dao;

import org.h2.engine.User;

import java.util.List;

public interface UserDao {

    //create
    void add(User user);

    //read
    List<User> getAll();
    // List<User> getAllUsersForADepartment(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
