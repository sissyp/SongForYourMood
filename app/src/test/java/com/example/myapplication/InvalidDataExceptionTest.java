package com.example.myapplication;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvalidDataExceptionTest {

    @Test
    public void functionsTest(){
        InvalidDataException in1 = new InvalidDataException("test message");
        Assert.assertEquals("test message", in1.getMessage());

        InvalidDataException in2 = new InvalidDataException();
        assertNull(in2.getMessage());
    }

}