package com.example.wangkun.comp6442_assignment_2_2016;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by wangkun on 1/05/16.
 *
 * @author Kun Wang and Zheng Zhang
 * @despription This class is for parse the input calculation formula and get the result.
 */
public abstract class Expression {
    /*This function is for parsing the calculation formula, when a formula send into this function,
     *it will firstly find the operator that last calculate, which is very similar to transfer the
     *infix expression to prefix expression. Then we don't need to consider the order of operations.
     * */
    public static Expression parse(String str, int signal){
        //when signal = 0, Rad mode opens, signal = 1 , Deg mode opens.
        if (str.equals("π")) {
            if (signal == 1) {
                return new Number(new BigDecimal(Math.pow(Math.PI, 2) / 180));
            } else
                return new Number(new BigDecimal(Math.PI));
        }

        if (str.equals("e")) {
            if (signal == 1) {
                return new Number(new BigDecimal(Math.PI * Math.E / 180));
            } else
                return new Number(new BigDecimal(Math.E));
        }

        //If the string start with operators like "+", "-" or "." we add a "0" before it
        if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '.') {
            str = "0" + str;
        }

        char num[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        //if the string start with a number and near by a bracket or an unary operator, we add "*"
        if (str.length() > 1) {
            for (int i = 0; i < num.length; i++) {
                if (str.charAt(0) == num[i] && str.charAt(1) == '(') {
                    String sub1 = str.substring(0, 1);
                    String sub2 = str.substring(1);
                    str = sub1 + "×" + sub2;
                }
                if (str.charAt(str.length() - 1) == num[i] && str.charAt(str.length() - 2) == ')') {
                    String sub1 = str.substring(str.length() - 2, str.length() - 1);
                    String sub2 = str.substring(str.length() - 1);
                    str = sub1 + "×" + sub2;
                }
                String sub1 = str.substring(0, 1);
                String sub2 = str.substring(1);
                if (str.charAt(0) == num[i] && haveScientificOperator(sub2))
                    str = sub1 + "×" + sub2;
            }
        }

        //If the whole string is in a pair of bracket, we delete the bracket.
        if (!haveOperator(str, '+') && !haveOperator(str, '-') && !haveOperator(str, '×') && !haveOperator(str, '/') && !haveOperator(str, '^')
                && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            str = str.substring(1, str.length() - 1);
            return parse(str, signal);
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
                    return new Addition(parse(substr1, signal), parse(substr2, signal));
                } else if (c == '-') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);
                    substr2 = str.substring(n);
                    if (haveOperator(substr2, '+') || haveOperator(substr2, '-')) {
                        continue;
                    }
                    return new Subtraction(parse(substr1, signal), parse(substr2, signal));
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
                    return new Multiplication(parse(substr1, signal), parse(substr2, signal));
                } else if (c == '/') {
                    if (inBrackets(n, str)) {
                        continue;
                    }
                    substr1 = str.substring(0, n - 1);

                    substr2 = str.substring(n);

                    if (haveOperator(substr2, '×') || haveOperator(substr2, '/')) {
                        continue;
                    }
                    return new Division(parse(substr1, signal), parse(substr2, signal));
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
                    return new Power(parse(substr1, signal), parse(substr2, signal));
                }
            }
        }


        if (haveScientificOperator(str)) {

            String ScientificOperator = str.substring(0, 4);
            String substr = str.substring(4);
            /*if(signal==1){
                BigDecimal b = new BigDecimal(substr);
                b = BigDecimal.valueOf(b.doubleValue() * Math.PI / 180);
                substr=b.toString();
            }*/
            switch (ScientificOperator) {
                case "sinh":
                    return new Sinh(parse(substr, signal));
                case "cosh":
                    return new Cosh(parse(substr, signal));
                case "tanh":
                    return new Tanh(parse(substr, signal));
                case "rand":
                    return new Rand(parse(substr, signal));
                case "sqrt":
                    return new Sqrt(parse(substr, signal));


            }

            ScientificOperator = str.substring(0, 3);
            substr = str.substring(3);

            switch (ScientificOperator) {
                case "sin":
                    return new Sin(parse(substr, signal));
                case "cos":
                    return new Cos(parse(substr, signal));
                case "tan":
                    return new Tan(parse(substr, signal));
                case "abs":
                    return new Abs(parse(substr, signal));
                case "log":
                    return new Log(parse(substr, signal));

            }
            ScientificOperator = str.substring(0, 2);
            substr = str.substring(2);
            switch (ScientificOperator) {
                case "ln":
                    return new Ln(parse(substr, signal));

            }
        }


        //System.out.println("the str is " + str);

        //consider the accuracy of double, choose the BigDecimal class to parse the string
        BigDecimal b = new BigDecimal(str);
        if (signal == 1) {
            b = BigDecimal.valueOf(b.doubleValue() * Math.PI / 180);
            return new Number(b);
        } else return new Number(b);
    }

    //If str contains scientific Operator,return true.
    public static boolean haveScientificOperator(String str) {
        if (str.length() < 5) {
            return false;
        }
        String ScientificOperator2 = str.substring(0, 2);
        String ScientificOperator3 = str.substring(0, 3);
        String ScientificOperator4 = str.substring(0, 4);
        ArrayList<String> ScientificOperators = new ArrayList<>();
        ScientificOperators.add("sin");
        ScientificOperators.add("cos");
        ScientificOperators.add("tan");
        ScientificOperators.add("sinh");
        ScientificOperators.add("cosh");
        ScientificOperators.add("tanh");
        ScientificOperators.add("abs");
        ScientificOperators.add("log");
        ScientificOperators.add("ln");
        ScientificOperators.add("rand");
        ScientificOperators.add("sqrt");

        return ScientificOperators.contains(ScientificOperator2) || ScientificOperators.contains(ScientificOperator3) || ScientificOperators.contains(ScientificOperator4);
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
    public static boolean haveOperator(String str, char operator) {

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
