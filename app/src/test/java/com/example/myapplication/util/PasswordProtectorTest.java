package com.example.myapplication.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordProtectorTest {

    @Test
    public void md5() {
        String res = PasswordProtector.md5("test");
        Assert.assertEquals(res, "98f6bcd4621d373cade4e832627b4f6");
        String res2 = PasswordProtector.md5("test");
        Assert.assertNotEquals(res2, "98f6bcd4621d373cade4e832627b4f7");
    }
}