package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 13/05/16.
 */
public class Tanh extends Expression {

    private Expression exp;

    public Tanh(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(tanh(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp.evaluate()==null)
            return null;
        else return BigDecimal.valueOf(Math.tanh(exp.evaluate().doubleValue()));
    }
}
