package com.example.wangkun.comp6442_assignment_2_2016;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by wangkun on 11/05/16.
 */
public class ScientificUnitTest {

    @Test
    public void ParseUnitTest() {
        Expression exp0 = Expression.parse("(4+3)^(2+1)");
        System.out.println(exp0.show());
        System.out.println(exp0.evaluate());
        Expression exp1 = Expression.parse("sin(π/2)");
        System.out.println(exp1.show());
        System.out.println(exp1.evaluate());
        Expression exp2 = Expression.parse("e+π");
        System.out.println(exp2.show());
        System.out.println(exp2.evaluate());
        Expression exp3 = Expression.parse("abs(1-2)");
        System.out.println(exp3.show());
        System.out.println(exp3.evaluate());
        Expression exp4 = Expression.parse("rand(3)");
        System.out.println(exp4.show());
        System.out.println(exp4.evaluate());
        Expression exp5 = Expression.parse("log(100)");
        System.out.println(exp5.show());
        System.out.println(exp5.evaluate());
        Expression exp6 = Expression.parse("ln(e^2)");
        System.out.println(exp6.show());
        System.out.println(exp6.evaluate());
        Expression exp7 = Expression.parse("sin(π)");
        System.out.println(exp7.show());
        System.out.println(exp7.evaluate());


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
        Abs abs = new Abs(Expression.parse("1-2"));
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

    @Test
    public void Big() {
        BigDecimal b = new BigDecimal("0.3333333333333333333").setScale(10, BigDecimal.ROUND_HALF_UP);
        System.out.println(b);
        b.setScale(5, BigDecimal.ROUND_HALF_UP);
        System.out.println(b);
        Random random = new Random();
        random.nextInt();
        System.out.println();
    }

}
