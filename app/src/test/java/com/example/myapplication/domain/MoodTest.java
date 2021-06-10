package com.example.myapplication.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MoodTest {

    @Test
    public void checkValidMood() {
        String mood = "happy";
        Assert.assertTrue(Mood.isAvailable(mood));
    }

    @Test
    public void checkInvalidMood() {
        String mood = "Xaroumenh";
        Assert.assertFalse(Mood.isAvailable(mood));
    }

    @Test
    public void getAvailableMoods() {
        Mood[] moods = {Mood.HAPPY, Mood.SAD, Mood.ANGRY, Mood.NOSTALGIC, Mood.STRESSED, Mood.CALM};
        Assert.assertArrayEquals(moods, Mood.getAvailableMoods());
    }
}