package com.example.wangkun.comp6442_assignment_2_2016;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


/**
 * Created by aprile on 8/05/16.
 */
public class ExpressionTest {
    Number a[] ={new Number(new BigDecimal("0.3")),new Number(new BigDecimal("0.5")),
            new Number(new BigDecimal("0.7")),new Number(new BigDecimal("0.9"))};
    Number a1 = new Number(new BigDecimal("0.3"));
    Number a2 = new Number(new BigDecimal("0.5"));
    Number a3 = new Number(new BigDecimal("0.7"));
    Number a4 = new Number(new BigDecimal("0.9"));

    Number b[] = {new Number(new BigDecimal("5")),new Number(new BigDecimal("6")),
            new Number(new BigDecimal("7")),new Number(new BigDecimal("8")),new Number(new BigDecimal("9"))
    };
    Number b1 = new Number(new BigDecimal("5"));
    Number b2 = new Number(new BigDecimal("6"));
    Number b3 = new Number(new BigDecimal("7"));
    Number b4 = new Number(new BigDecimal("8"));


    @Test
    public void mulTest(){
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<b.length;j++){
//                Expression mul = new Multiplication(a[i],b[j]);
//                BigDecimal result = mul.evaluate();
//                System.out.println(a[i].value*b[j].value);
//                assertEquals(result.doubleValue(),a[i].value*b[j].value,0);
//            }
//        }
        Expression mul1 = new Multiplication(a1,b1);
        BigDecimal result1 = mul1.evaluate();
        assertEquals(result1.doubleValue(),1.5,0);

        Expression mul2 = new Multiplication(a2,b2);
        BigDecimal result2 = mul2.evaluate();
        assertEquals(result2.doubleValue(),3.0,0);

        Expression mul3 = new Multiplication(a3,b3);
        BigDecimal result3 = mul3.evaluate();
        assertEquals(result3.doubleValue(),4.9,0);

        Expression mul4 = new Multiplication(a4,b4);
        BigDecimal result4 = mul4.evaluate();
        assertEquals(result4.doubleValue(),7.2,0);
    }

    @Test
    public void addTest(){
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<b.length;j++){
//                Expression mul = new Multiplication(a[i],b[j]);
//                BigDecimal result = mul.evaluate();
//                System.out.println(a[i].value*b[j].value);
//                assertEquals(result.doubleValue(),a[i].value*b[j].value,0);
//            }
//        }
        Expression mul1 = new Addition(a1,b1);
        BigDecimal result1 = mul1.evaluate();
        assertEquals(result1.doubleValue(),5.3,0);

        Expression mul2 = new Addition(a2,b2);
        BigDecimal result2 = mul2.evaluate();
        assertEquals(result2.doubleValue(),6.5,0);

        Expression mul3 = new Addition(a3,b3);
        BigDecimal result3 = mul3.evaluate();
        assertEquals(result3.doubleValue(),7.7,0);

        Expression mul4 = new Addition(a4,b4);
        BigDecimal result4 = mul4.evaluate();
        assertEquals(result4.doubleValue(),8.9,0);
    }

    @Test
    public void subTest(){
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<b.length;j++){
//                Expression mul = new Multiplication(a[i],b[j]);
//                BigDecimal result = mul.evaluate();
//                System.out.println(a[i].value*b[j].value);
//                assertEquals(result.doubleValue(),a[i].value*b[j].value,0);
//            }
//        }
        Expression mul1 = new Subtraction(a1,b1);
        BigDecimal result1 = mul1.evaluate();
        assertEquals(result1.doubleValue(),-4.7,0);

        Expression mul2 = new Subtraction(a2,b2);
        BigDecimal result2 = mul2.evaluate();
        assertEquals(result2.doubleValue(),-5.5,0);

        Expression mul3 = new Subtraction(a3,b3);
        BigDecimal result3 = mul3.evaluate();
        assertEquals(result3.doubleValue(),-6.3,0);

        Expression mul4 = new Subtraction(a4,b4);
        BigDecimal result4 = mul4.evaluate();
        assertEquals(result4.doubleValue(),-7.1,0);
    }

    @Test
    public void divTest(){
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<b.length;j++){
//                Expression mul = new Multiplication(a[i],b[j]);
//                BigDecimal result = mul.evaluate();
//                System.out.println(a[i].value*b[j].value);
//                assertEquals(result.doubleValue(),a[i].value*b[j].value,0);
//            }
//        }
        Expression mul1 = new Division(a1,b1);
        BigDecimal result1 = mul1.evaluate();
        assertEquals(result1.doubleValue(),0.06,0);

        Expression mul2 = new Division(b2,a2);
        BigDecimal result2 = mul2.evaluate();
        assertEquals(result2.doubleValue(),12,0);

        Expression mul3 = new Division(a3,b3);
        BigDecimal result3 = mul3.evaluate();
        assertEquals(result3.doubleValue(),0.1,0);

    }
}
