package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 11/05/16.
 */
public class Sin extends Expression {

    private Expression exp;

    public Sin(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(sin(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp.evaluate()==null)
            return null;
        else return BigDecimal.valueOf(Math.sin(exp.evaluate().doubleValue()));
    }
}
