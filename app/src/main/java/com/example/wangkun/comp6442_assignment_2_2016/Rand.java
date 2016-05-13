package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by wangkun on 13/05/16.
 */
public class Rand extends Expression {

    private Expression exp;

    public Rand(Expression exp) {
        super();
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(rand(" + exp.show() + "))";
    }

    @Override
    public BigDecimal evaluate() {
        Random random = new Random();
        int n = exp.evaluate().intValue();
        int value = random.nextInt(n);
        double rtn = (double) value;
        rtn /= 1000;
        return BigDecimal.valueOf(rtn);
    }
}
