package com.example.myapplication.dao;

import com.example.myapplication.domain.User;

/**
 * UserDAOStub is the interface of the users' database.
 */

public interface UserDAOStub {
    /**
     * getUserFromCredentials searches the list of all users in order to find the one that
     * has the email and password given.
     * @param email is the email of the user.
     * @param password is the password of the user.
     * @return the user that matches the specific criteria.
     */

    User getUserFromCredentials(String email, String password);

    /**
     * isEmailTaken searches if there is a user with the same email address stored in the database.
     * @param email is the email address of the user.
     * @return true if email already belongs to another user in the database.
     */

    boolean isEmailTaken(String email);

    /**
     * register saves a user and all his data in the database.
     * @param user is the user to be stored.
     */

    void register(User user);

    /**
     * delete erases a user from the database.
     * @param userId is the id of the user to be deleted.
     */

    void delete(int userId);

    /**
     * nextId
     * @return the id of the next user.
     */

    int nextId();
}
