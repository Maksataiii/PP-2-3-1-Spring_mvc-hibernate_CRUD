package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import javax.persistence.Table;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id,user);
    }

    @Override
    @Transactional
    public User show_user(int id) {
        return userDao.show_user(id);
    }
}
