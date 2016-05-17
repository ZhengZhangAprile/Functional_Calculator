package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 13/05/16.
 */
public class Log extends Expression {

    private Expression exp;

    public Log(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(log(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp.evaluate()==null||exp.evaluate().compareTo(BigDecimal.valueOf(0))<=0)
            return null;
        else return BigDecimal.valueOf(Math.log10(exp.evaluate().doubleValue()));
    }
}
