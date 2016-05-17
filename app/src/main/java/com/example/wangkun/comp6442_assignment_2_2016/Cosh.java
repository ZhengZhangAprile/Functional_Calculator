package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 13/05/16.
 */
public class Cosh extends Expression {

    private Expression exp;

    public Cosh(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(cosh(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp.evaluate()==null){
            return null;
        }
        else return BigDecimal.valueOf(Math.cosh(exp.evaluate().doubleValue()));
    }
}
