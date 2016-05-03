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


        //If the string start with operators like "+", "-" or "." we add a "0" before it
        if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '×' || str.charAt(0) == '/' || str.charAt(0) == '.') {
            str = "0" + str;
        }

        //If the whole string is in a pair of bracket, we delete the bracket.
        if (!haveOperator(str, '+') && !haveOperator(str, '-') && !haveOperator(str, '×') && !haveOperator(str, '/')
                && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            str = str.substring(1, str.length() - 1);
        }

        if (haveOperator(str, '+') || haveOperator(str, '-')) {
            int n = 0;
            String substr1 = "";
            String substr2 = "";
            for (char c : str.toCharArray()) {
                n++;
                if (c == '+') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);
                    substr2 = str.substring(n);
                    if (haveOperator(substr2, '+') || haveOperator(substr2, '-')) {
                        continue;
                    }
                    return new Addition(parse(substr1), parse(substr2));
                } else if (c == '-') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);
                    substr2 = str.substring(n);
                    if (haveOperator(substr2, '+') || haveOperator(substr2, '-')) {
                        continue;
                    }
                    return new Subtraction(parse(substr1), parse(substr2));
                }
            }
        }


        if (haveOperator(str, '×') || haveOperator(str, '/')) {
            int n = 0;
            String substr1 = "";
            String substr2 = "";
            for (char c : str.toCharArray()) {
                n++;
                if (c == '×') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);
                    substr2 = str.substring(n);
                    if (haveOperator(substr2, '×') || haveOperator(substr2, '/')) {
                        continue;
                    }
                    return new Multiplication(parse(substr1), parse(substr2));
                } else if (c == '/') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);

                    substr2 = str.substring(n);

                    if (haveOperator(substr2, '×') || haveOperator(substr2, '/')) {
                        continue;
                    }
                    return new Division(parse(substr1), parse(substr2));
                }
            }
        }


        System.out.println("the str is " + str);
        return new Number(Double.parseDouble(str));
    }

    //check if a operator is in a pair of bracket; the first position is 1.
    public static boolean inBrackets(int position, String str) {
        String substr = str.substring(position);
        char[] chars = substr.toCharArray();
        int leftBrackets = 0, rightBrackets = 0;
        for (char c : chars) {
            if (c == '(') {
                leftBrackets++;
            } else if (c == ')') {
                rightBrackets++;
            }
        }
        return rightBrackets > leftBrackets;
    }

    //check if an expression contains operator, if the operator is in brackets, return false
    private static boolean haveOperator(String str, char operator) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == operator && !inBrackets(i, str)) {
                return true;
            }
        }
        return false;
    }

}
