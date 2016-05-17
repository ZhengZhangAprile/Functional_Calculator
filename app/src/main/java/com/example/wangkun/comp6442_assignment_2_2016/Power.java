package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 12/05/16.
 */
public class Power extends Expression {

    private Expression exp1, exp2;

    public Power(Expression exp1, Expression exp2) {
        super();
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public String show() {
        return "(^ " + exp1.show() + " " + exp2.show() + ")";
    }

    @Override
    public BigDecimal evaluate() {
        if(exp1.evaluate()==null||exp2.evaluate()==null)
            return null;
        else return BigDecimal.valueOf(Math.pow(exp1.evaluate().doubleValue(),exp2.evaluate().doubleValue()));
    }
}
