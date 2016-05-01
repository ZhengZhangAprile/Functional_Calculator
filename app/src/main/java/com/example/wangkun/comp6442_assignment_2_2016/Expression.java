package com.example.wangkun.comp6442_assignment_2_2016;

/**
 * Created by wangkun on 1/05/16.
 */
public abstract class Expression {
    /*  This method prints an expression as a string
       (which could be parsed back into a expression) */
    public abstract String show();

    /* This method evaluates the expression */
    public abstract float evaluate();

    static public Expression parse(String str) {

        if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '*' || str.charAt(0) == '/') {
            str = "0" + str;
        }

        if (str.contains("+") || str.contains("-")) {
            int n = 0;
            String substr1 = "";
            String substr2 = "";
            for (char c : str.toCharArray()){
                n++;
                if (c == '+'){
                    substr1 = str.substring(0,n-1);
                    substr2 = str.substring(n);
                    if (substr2.contains("+") || substr2.contains("-")) {
                        continue;
                    }
                    return new Addition(parse(substr1), parse(substr2));
                } else if (c == '-') {
                    substr1 = str.substring(0,n-1);
                    substr2 = str.substring(n);
                    if (substr2.contains("+") || substr2.contains("-")) {
                        continue;
                    }
                    return new Subtraction(parse(substr1), parse(substr2));
                }
            }
        }



        if (str.contains("*") || str.contains("/")) {
            int n = 0;
            String substr1 = "";
            String substr2 = "";
            for (char c : str.toCharArray()){
                n++;
                if (c == '*'){
                    substr1 = str.substring(0,n-1);
                    substr2 = str.substring(n);
                    if (substr2.contains("*") || substr2.contains("/")) {
                        continue;
                    }
                    return new Multiplication(parse(substr1), parse(substr2));
                } else if (c == '/') {
                    substr1 = str.substring(0,n-1);
                    substr2 = str.substring(n);
                    if (substr2.contains("*") || substr2.contains("/")) {
                        continue;
                    }
                    return new Division(parse(substr1), parse(substr2));
                }
            }
        }

        return new Number(Double.parseDouble(str));
    }

    private static boolean inBracket(int position, String str) {

        position--;
        char me = str.charAt(position);
        if (me == '(' || me == ')') {
            return false;
        }
        String substr = str.substring(position);
        char[] chars = substr.toCharArray();
        for (char c : chars) {
            if (c == ')') {
                return true;
            } else if (c == '(') {
                return false;
            }
        }
        return false;
    }

}
