package com.example.myapplication.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void checkValidActivity() {
        String act = "party";
        Assert.assertTrue(Activity.isAvailable(act));
    }

    @Test
    public void checkInvalidActivity() {
        String act = "lol";
        Assert.assertFalse(Activity.isAvailable(act));
    }

    @Test
    public void checkAvailableActivities() {
        Activity[] activities = {Activity.WORK, Activity.STUDYING, Activity.WORKING_OUT, Activity.PARTY, Activity.HOBBY, Activity.NO_ACTIVITY};
        Assert.assertArrayEquals(activities, Activity.getAvailableActivities());
    }
}