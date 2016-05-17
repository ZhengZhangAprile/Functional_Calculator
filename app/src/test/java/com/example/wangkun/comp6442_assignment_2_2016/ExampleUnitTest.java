package com.example.wangkun.comp6442_assignment_2_2016;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 * @author Kun Wang
 */

public class ExampleUnitTest {
    @Test
    public void inBrackets_isCorrect() {

        String str = "1*(2+3)*4";

        assertFalse(Expression.inBrackets(2,str));
        assertTrue(Expression.inBrackets(5,str));
        assertFalse(Expression.inBrackets(8,str));

        str = "((1+2)*3/4+5)*6/(7-8)";
        assertTrue(Expression.inBrackets(4,str));
        assertTrue(Expression.inBrackets(7,str));
        assertTrue(Expression.inBrackets(9,str));
        assertTrue(Expression.inBrackets(11,str));
        assertTrue(Expression.inBrackets(17,str));

        assertFalse(Expression.inBrackets(14,str));
        assertFalse(Expression.inBrackets(16,str));

    }

    @Test
    public void test(){
        System.out.println(Math.tan(Math.PI/2));

    }
}