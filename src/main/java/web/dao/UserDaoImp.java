package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void remove(int id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public void update(int id, User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User show_user(int id) {
        return (User) sessionFactory.getCurrentSession().get(
                User.class, id);
    }
//    private static int USER_COUNT;
//    private List<User> users;
//    {
//        users = new ArrayList<>();
//        users.add(new User(++USER_COUNT,"Maksatai","Karimova","erkbvna@gmail.com"));
//        users.add(new User(++USER_COUNT,"Kunduz","Razzakova","kunduz@gmail.com"));
//        users.add(new User(++USER_COUNT,"Nur","Yugai","yugainur@gmail.com"));
//    }
//
//    @Override
//    public List<User> getUsers() {
//        return users;
//    }
//
//    @Override
//    public User show_user(int id){
//        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
//    }
//
//    @Override
//    public void save(User user) {
//        user.setId(++USER_COUNT);
//        users.add(user);
//    }
//
//
//    @Override
//    public void update(int id, User user) {
//        User userToBeUpdated = show_user(id);
//        userToBeUpdated.setFirstName(user.getFirstName());
//        userToBeUpdated.setLastName(user.getLastName());
//        userToBeUpdated.setEmail(user.getEmail());
//    }
//
//    @Override
//    public void remove(int id) {
//        users.removeIf(p->p.getId()==id);
//
//    }

}
