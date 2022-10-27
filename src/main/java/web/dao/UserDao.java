package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT,"Maksatai","Karimova","erkbvna@gmail.com"));
        users.add(new User(++USER_COUNT,"Kunduz","Razzakova","kunduz@gmail.com"));
        users.add(new User(++USER_COUNT,"Nur","Yugai","yugainur@gmail.com"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User show_user(int id){
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User user) {
        User userToBeUpdated = show_user(id);
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setEmail(user.getEmail());
    }

    public void remove(int id) {
        users.removeIf(p->p.getId()==id);

    }
}
