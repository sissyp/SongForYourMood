package com.example.myapplication.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class IntensityTest {

    @Test
    public void checkValidIntensity() {
        String intens = "high";
        Assert.assertTrue(Intensity.isAvailable(intens));
    }

    @Test
    public void checkInvalidIntensity() {
        String intens = "Dunath";
        Assert.assertFalse(Intensity.isAvailable(intens));
    }

    @Test
    public void getAvailableIntensityLevels() {
        Intensity[] levels = {Intensity.HIGH, Intensity.MEDIUM, Intensity.LOW};
        Assert.assertArrayEquals(levels, Intensity.getIntensityLevels());
    }
}