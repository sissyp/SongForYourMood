package com.example.myapplication.memorydao;
import java.util.ArrayList;
import java.util.List;


import com.example.myapplication.dao.UserDAOStub;
import com.example.myapplication.domain.User;

/**
 * UserDAO represents the users' database.
 */

public class UserDAO implements UserDAOStub {
    protected static List<User> usersList = new ArrayList<>();
    private static int userIdCounter = 0;

    /**
     * getUserFromCredentials searches the list of all users in order to find the one that
     * has the email and password given.
     * @param email is the email of the user.
     * @param password is the password of the user.
     * @return the user that matches the specific criteria.
     */

    @Override
    public User getUserFromCredentials(String email, String password) {
        for (User user : usersList) {
            if (user.getMail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * isEmailTaken searches if there is a user with the same email address stored in the database.
     * @param email is the email address of the user.
     * @return true if email already belongs to another user in the database.
     */

    @Override
    public boolean isEmailTaken(String email) {
        for (User user : usersList) {
            if (user.getMail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * register saves a user and all his data in the database.
     * @param user is the user to be stored.
     */

    @Override
    public void register(User user) {
        delete(user.getUserId());
        user.setUserId(nextId());
        usersList.add(user);
    }

    /**
     * delete erases a user from the database.
     * @param userId is the id of the user to be deleted.
     */

    @Override
    public void delete(int userId) {
        for (User u : usersList) {
            if (u.getUserId() == userId) {
                usersList.remove(u);
                break;
            }
        }
    }

    /**
     * nextId
     * @return the id of the next user.
     */

    @Override
    public int nextId() {
        userIdCounter++;
        return userIdCounter;
    }
}
