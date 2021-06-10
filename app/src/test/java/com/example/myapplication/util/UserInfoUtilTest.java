package com.example.myapplication.util;

import org.junit.Test;

import org.junit.Assert;

public class UserInfoUtilTest {

    @Test
    public void checkValidEmail() {
        String email = "FootClan@gmail.gr";
        Assert.assertTrue(UserInfoUtil.isEmail(email));
    }

    @Test
    public void checkInvalidEmail() {
        String email = "FootClan@";
        Assert.assertFalse(UserInfoUtil.isEmail(email));
    }
}