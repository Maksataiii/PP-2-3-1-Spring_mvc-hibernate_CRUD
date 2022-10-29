package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void save(User user);
    void remove(int id);
    void update(int id,User user);
    User show_user(int id);
}
