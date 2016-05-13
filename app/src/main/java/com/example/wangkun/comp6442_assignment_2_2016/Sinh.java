package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 13/05/16.
 */
public class Sinh extends Expression {

    private Expression exp;

    public Sinh(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(sinh(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        return BigDecimal.valueOf(Math.sinh(exp.evaluate().doubleValue()));
    }
}
