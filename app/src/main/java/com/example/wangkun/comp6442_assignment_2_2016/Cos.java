package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 12/05/16.
 */
public class Cos extends Expression {

    private Expression exp;

    public Cos(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(cos(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp.evaluate()==null)
            return null;
        else return BigDecimal.valueOf(Math.cos(exp.evaluate().doubleValue()));
    }
}
