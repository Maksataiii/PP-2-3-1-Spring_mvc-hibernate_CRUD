package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
//    void add(User user);
//    List<User> listUsers();
//
//    List<User> list();
    List<User> getUsers();
    void save(User user);
    void remove(int id);
    void update(int id, User user);
    User show_user(int id);
}
