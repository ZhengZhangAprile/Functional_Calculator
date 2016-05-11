package com.example.wangkun.comp6442_assignment_2_2016;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangkun on 11/05/16.
 */
public class ScientificUnitTest {

    @Test
    public void SinUnitTest() {
        Sin sin = new Sin(new Number(new BigDecimal("1.57079632679")));
        System.out.println(sin.evaluate());
        //assertEquals(sin.evaluate(),1);

    }
}
