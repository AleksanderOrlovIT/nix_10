package ua.com.alevel.db;

import ua.com.alevel.entity.User;

import java.util.Arrays;
import java.util.UUID;

public class DBUser {
    private User[] users;
    private static DBUser instance;

    private DBUser() {
        users = new User[0];
    }

    public static DBUser getInstance() {
        if (instance == null) {
            instance = new DBUser();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < users.length; i++)
            if (id.equals(String.valueOf(users[i].getId()))) {
                return generateId();
            }
        return id;
    }

    public int usersNumber() {
        return users.length;
    }

    public void update(User user) {
        User current = findById(user.getId());
        current.setName(user.getName());
        current.setAge(user.getAge());
    }

    public User findById(String id) {
        for (int i = 0; i < users.length; i++) {
            if (id.equals(String.valueOf(users[i].getId()))) return users[i];
        }
        return users[users.length];
    }

    public User[] findAll() {
        return users;
    }

    public void delete(String id) {
        User userToDelete = findById(id);
        int temp = -1;
        for (int i = 0; i < users.length; i++) {
            if(users[i].getId().equals(String.valueOf(userToDelete.getId()))){
                users[i] = null;
                temp = i;
            }
        }

        User tempArray[] = new User[users.length - 1];

        for (int i = 0; i < temp; i++) {
            tempArray[i] = users[i];
        }

        for (int i = temp; i < tempArray.length; i++) {
            tempArray[i] = users[i+1];
        }

        users = Arrays.copyOf(tempArray, users.length - 1);
    }


    public boolean existByEmail(String email) {
        for (int i = 0; i < users.length; i++) {
            if (email.equals(String.valueOf(users[i].getEmail()))) {
                return true;
            }
        }
        return false;
    }
}
