package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by u5642032 on 14/05/16.
 */
public class Sqrt extends Expression {

    private Expression exp;

    public Sqrt(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(sqrt(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp.evaluate()==null||exp.evaluate().compareTo(BigDecimal.valueOf(0))<0)
            return null;
        else return BigDecimal.valueOf(Math.sqrt(exp.evaluate().doubleValue()));
    }
}
