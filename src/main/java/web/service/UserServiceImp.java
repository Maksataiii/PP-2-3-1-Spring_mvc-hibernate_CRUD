package web.service;

import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

public class UserServiceImp implements UserService{
    private UserDao userDao = new UserDaoImp();

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    public void update(int id, User user) {
        userDao.update(id,user);
    }

    @Override
    public User show_user(int id) {
        return userDao.show_user(id);
    }
}
