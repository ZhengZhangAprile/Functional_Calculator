package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by wangkun on 1/05/16.
 */
public abstract class Expression {
    public static Expression parse(String str) {

        if (str.equals("π")) {
            return new Number(new BigDecimal(Math.PI));
        }

        if (str.equals("e")) {
            return new Number(new BigDecimal(Math.E));
        }

        //If the string start with operators like "+", "-" or "." we add a "0" before it
        if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '.') {
            str = "0" + str;
        }

        //If the whole string is in a pair of bracket, we delete the bracket.
        if (!haveOperator(str, '+') && !haveOperator(str, '-') && !haveOperator(str, '×') && !haveOperator(str, '/') && !haveOperator(str, '^')
                && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            str = str.substring(1, str.length() - 1);
        }

        if (haveOperator(str, '+') || haveOperator(str, '-')) {
            //if there is a negative or positive operator in a bracket, here need add a zero before the operator
            if (str.charAt(0) == '+' || str.charAt(0) == '-')
                str = "0" + str;

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

        if (haveOperator(str, '^')) {
            int n = 0;
            String substr1 = "";
            String substr2 = "";
            for (char c : str.toCharArray()) {
                n++;
                if (c == '^') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);
                    substr2 = str.substring(n);
                    if (haveOperator(substr2, '^')) {
                        continue;
                    }
                    return new Power(parse(substr1), parse(substr2));
                }
            }
        }

        if (haveScientificOperator(str)) {
            String ScientificOperator = str.substring(0, 3);
            String substr = str.substring(3);
            switch (ScientificOperator) {
                case "sin":
                    return new Sin(parse(substr));
                case "cos":
                    return new Cos(parse(substr));
                case "tan":
                    return new Tan(parse(substr));

            }
        }


        //System.out.println("the str is " + str);
        //consider the accuracy of double, choose the BigDecimal class to parse the string
        BigDecimal b = new BigDecimal(str);
        return new Number(b);
    }

    public static boolean haveScientificOperator(String str) {

        if (str.length() < 4) {
            return false;
        }
        String ScientificOperator = str.substring(0, 3);
        //{"sin", "cos", "tan", "cot", "abs", "log", "ln ", "rdm"}
        ArrayList<String> ScientificOperators = new ArrayList<>();
        ScientificOperators.add("sin");
        ScientificOperators.add("cos");
        ScientificOperators.add("tan");
        //ScientificOperators.add("sih");
        //ScientificOperators.add("csh");
        //ScientificOperators.add("tah");
        ScientificOperators.add("abs");
        ScientificOperators.add("log");
        ScientificOperators.add("ln ");
        ScientificOperators.add("rdm");

        return ScientificOperators.contains(ScientificOperator);
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

    /*  This method prints an expression as a string
       (which could be parsed back into a expression) */
    public abstract String show();

    /* This method evaluates the expression */
    public abstract BigDecimal evaluate();

}
