package com.example.myapplication.util;

import com.example.myapplication.InvalidDataException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class UserActionTimeTest {

    UserActionTime loggIn;

    @Before
    public void init() throws InvalidDataException {
        loggIn = UserActionTime.setTime(2021, 5, 21, 6, 6, 6);
    }

    @Test
    public void checkDateAndTime() throws InvalidDataException {
        UserActionTime time1 = UserActionTime.setTime(2021, 10, 11, 12, 44, 19);
        String readableTime = time1.getDateAndTime();
        Assert.assertEquals(readableTime, "2021-10-11 12:44:19");
    }

    @Test(expected = InvalidDataException.class)
    public void setDay() throws InvalidDataException {
        loggIn.setDay(12);
        loggIn.setDay(80);
    }

    @Test(expected = InvalidDataException.class)
    public void setMonth() throws InvalidDataException {
        loggIn.setMonth(11);
        loggIn.setMonth(99);
    }

    @Test(expected = InvalidDataException.class)
    public void setYear() throws InvalidDataException {
        loggIn.setYear(1968);
        loggIn.setYear(-999);
    }

    @Test(expected = InvalidDataException.class)
    public void setHour() throws InvalidDataException {
        loggIn.setHour(12);
        loggIn.setHour(800);
    }

    @Test(expected = InvalidDataException.class)
    public void setMinutes() throws InvalidDataException {
        loggIn.setMinutes(50);
        loggIn.setSeconds(500);
    }

    @Test(expected = InvalidDataException.class)
    public void setSeconds() throws InvalidDataException {
        loggIn.setSeconds(44);
        loggIn.setSeconds(404);
    }
}
