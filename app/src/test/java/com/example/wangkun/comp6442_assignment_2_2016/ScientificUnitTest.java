package com.example.wangkun.comp6442_assignment_2_2016;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Kun Wang and Zheng Zhang
 */
public class ScientificUnitTest{

    @Test
    public void ParseUnitTest() {
        Expression exp0 = Expression.parse("(4+3)^(2+1)",0);
        assertEquals(exp0.evaluate().intValue(),343);
        //System.out.println(exp0.evaluate());
        Expression exp1 = Expression.parse("sin(π/2)",0);
        assertEquals(exp1.evaluate().intValue(),1);
        //System.out.println(exp1.evaluate());
        Expression exp2 = Expression.parse("abs(1-2)",0);
        assertEquals(exp2.evaluate().intValue(),1);
        //System.out.println(exp2.evaluate());
    }

    @Test
    public void TrigonometricFunctionsUnitTest() {
        Sin sin = new Sin(new Number(new BigDecimal(Math.PI / 2)));
        assertEquals(sin.show(), "(sin(1.5707963267948965579989817342720925807952880859375))");
        assertEquals(sin.evaluate(), BigDecimal.valueOf(1.0));

        Cos cos = new Cos(new Number(new BigDecimal(Math.PI / 2)));
        assertEquals(cos.show(), "(cos(1.5707963267948965579989817342720925807952880859375))");
        assertEquals(cos.evaluate(), BigDecimal.valueOf(6.123233995736766E-17));

    }

    @Test
    public void AbsUnitTest() {
        Abs abs = new Abs(Expression.parse("1-2",0));
        System.out.println(abs.show());
        System.out.println(abs.evaluate());
    }

    @Test
    public void PowerUnitTest() {
        Power power0 = new Power(new Number(new BigDecimal("2")), new Number(new BigDecimal("3")));
        Power power1 = new Power(new Number(new BigDecimal("2")), new Number(new BigDecimal("0")));
        Power power2 = new Power(new Number(new BigDecimal("2")), new Number(new BigDecimal("-1")));

        assertEquals(power0.show(), "(^ 2 3)");
        assertEquals(power0.evaluate(), BigDecimal.valueOf(8.0));
        assertEquals(power1.show(), "(^ 2 0)");
        assertEquals(power1.evaluate(), BigDecimal.valueOf(1.0));
        assertEquals(power2.show(), "(^ 2 -1)");
        assertEquals(power2.evaluate(), BigDecimal.valueOf(0.5));
    }

    @Test
    public void haveScientificOperatorUnitTest() {
        assertTrue(Expression.haveScientificOperator("sin(12)"));
        assertFalse(Expression.haveScientificOperator("sin"));
        assertFalse(Expression.haveScientificOperator("5+5+5+5"));
        assertFalse(Expression.haveScientificOperator("4"));

        String str = "sin(12)";
        String ScientificOperator = str.substring(0, 3);
        String substr = str.substring(3);
        System.out.println(ScientificOperator);
        System.out.println(substr);
    }
}
