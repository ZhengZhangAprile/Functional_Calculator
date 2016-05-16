package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;

/**
 * Created by wangkun on 1/05/16.
 */
public class Number extends Expression {

    private BigDecimal x;
    double value;

    public Number(BigDecimal x) {
        super();
        this.x =  x;
        this.value = x.doubleValue();
    }

    public Number(double x){
        super();
        this.value= x;
    }


    @Override
    public String show() {
        return x + "";
    }

    @Override
    public BigDecimal evaluate() {
        return x;
    }
}
