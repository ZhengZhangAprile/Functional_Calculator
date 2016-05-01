package com.example.wangkun.comp6442_assignment_2_2016;

/**
 * Created by wangkun on 1/05/16.
 */
public class Number extends Expression {

    private float x;

    public Number(double x) {
        super();
        this.x = (float) x;
    }

    @Override
    public String show() {
        return x + "";
    }

    @Override
    public float evaluate() {
        return x;
    }
}
