package ua.com.alevel.service;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

public class UserService {

    private static final UserDao userDao = new UserDao();

    public static void create(User user) {
        if (!userDao.existByEmail(user.getEmail())) {
            userDao.create(user);
        } else {
            System.out.println("user exist by email");
        }
    }

    public static void update(User user) {
        userDao.update(user);
    }

    public static void delete(String id) {
        userDao.delete(id);
    }

    public static User findById(String id) {
        return userDao.findById(id);
    }

    public static User[] findAll() {
        return userDao.findAll();
    }
}
