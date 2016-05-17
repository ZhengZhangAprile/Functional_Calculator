package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 12/05/16.
 */
public class Tan extends Expression {

    private Expression exp;

    public Tan(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(tan(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        double result = Math.tan(exp.evaluate().doubleValue());
        if(exp.evaluate()==null)
            return null;
        else return BigDecimal.valueOf(result);
    }
}
