package com.example.wangkun.comp6442_assignment_2_2016;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Zheng Zhang on 5/17/2016.
 */
public class FunctionTest {
    MainActivity m = new MainActivity();
    ScientificActivity s = new ScientificActivity();
    String str1 = "()+9";
    String str2 = "9-2/";
    String str3 = "/9+8";
    String str4 = "(9-7))";
    String str5 = "9+/8";

    @Test
    public void hasExceptionTest(){
        assertEquals(m.hasException(str1),"two operators near by");
        assertEquals(m.hasException(str2),"parameter missing");
        assertEquals(m.hasException(str3),"parameter missing");
        assertEquals(m.hasException(str4),"bracket missing");
        assertEquals(m.hasException(str5),"two operators near by");
        assertEquals(s.hasException(str4),"bracket missing");
        assertEquals(s.hasException(str5),"two operators near by");
    }

    @Test
    public void hasOperatorTest(){
        assertTrue(Expression.haveOperator(str1,'+'));
        assertTrue(Expression.haveOperator(str2,'-'));
        assertTrue(Expression.haveOperator(str3,'/'));
        assertFalse(Expression.haveOperator(str4, '-'));
        assertTrue(Expression.haveOperator(str5,'+'));
    }
}
