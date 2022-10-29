package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao{
    private static int USER_COUNT;
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT,"Maksatai","Karimova","erkbvna@gmail.com"));
        users.add(new User(++USER_COUNT,"Kunduz","Razzakova","kunduz@gmail.com"));
        users.add(new User(++USER_COUNT,"Nur","Yugai","yugainur@gmail.com"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User show_user(int id){
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }


    @Override
    public void update(int id, User user) {
        User userToBeUpdated = show_user(id);
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setEmail(user.getEmail());
    }

    @Override
    public void remove(int id) {
        users.removeIf(p->p.getId()==id);

    }
}
