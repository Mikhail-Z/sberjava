package com.company;

import org.junit.*;

public class SummatorTest {

    @Test
    public void sum() {
        //arrange
        Summator summator = new Summator();
        int expected = 5;

        //act
        int sum = summator.sum(3, 2);

        //assert
        Assert.assertEquals(expected, sum);
    }
}
