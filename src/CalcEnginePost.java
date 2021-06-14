import java.util.Scanner;

public class CalcEnginePost extends CalcEngine {

    String displayValue = "";


    public CalcEnginePost() {
        super();
    }

    public void evaluateInfix(String infix) {

//        infix = infix.replaceAll(".", "$0 ");

        String postfix = infixToPostfix(infix);
        int result = evaluate(postfix);
        String str = Integer.toString(result);
        displayValue = str;
    }

    public String getStringDisplayValue() {
        return displayValue;
    }

    /**
     * Evaluate the value of an expression in Reverse Polish Notation/Postfix
     *
     * @param pfx String containing the expression
     * @return Integer value of the given expression
     */
    public int evaluate(String pfx) {
        // variables holding left-hand side and right-hand side of an expression
        int lhs = 0;
        int rhs = 0;

        Stack s = new StackAsList();

        // Create an array of all tokens to check, instead of substrings
        // in regard of assignment 6 to check multidigit expressions
        String[] tokens = pfx.split("[\\s]");

        // Variable holding the result
        int r = 0;

        // While the array is not looped through
        int i = 0;
        while (i < tokens.length) {
            // If it is an operator, take the first two
            //operands from the stack and calculate them accordingly
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("^")) {
                // Store the operands in respective sides
                rhs = Integer.parseInt(s.pop());
                lhs = Integer.parseInt(s.pop());

                // Do following calculations depending on found operator
                switch (tokens[i]) {
                    case "+":
                        r = lhs + rhs;
                        break;
                    case "-":
                        r = lhs - rhs;
                        break;
                    case "*":
                        r = lhs * rhs;
                        break;
                    case "/":
                        r = (int) (1.0 * lhs / 1.0 * rhs);
                        break;
                    case "^":
                        r = (int) Math.pow(lhs, rhs);
                        break;
                }
                // Push the result to the stack
                s.push(Integer.toString(r));
            } else {
                // If it's an operand push it on top of the stack
                if (tokens[i].matches("\\d")) { // If is a digit
                    s.push(tokens[i]); // just push it
                } else { // If it's a latter A-F
                    s.push("" + Integer.parseInt(tokens[i], 16)); //convert Value and push as String
                }
            }
            // When done with the current token, move on
            i++;
        }
        // When finished return the resulting integer
        return r;
    }

    /**
     * Convert any standard arithmetic expression from
     * infix notation to Reverse Polish Notation /Postfix
     *
     * @param ifx String containing the expression to convert
     * @return String of the resulting postfix expression
     */
    // Assignment 4
    public String infixToPostfix(String ifx) {
        // Almost like the former method, lots of copy-paste, similar comments removed
        Stack s = new StackAsList();

        String[] tokens = ifx.split("[\\s]");

        String r = "";

        int i = 0;
        // Step by step implementation of given algorithm
        // https://people.f4.htw-berlin.de/~weberwu/info2/Handouts/Postfix-evaluation.html
        while (i < tokens.length) {

            // if t is an open parenthesis
            if (tokens[i].equals("(")) {
                s.push(tokens[i]); // push it
            }

            // if t is an closing parenthesis
            else if (tokens[i].equals(")")) {
                // while top <> opening parenthesis
                while (!s.peek().equals("(")) {
                    r = r + " " + s.pop();
                }
                s.pop(); //if it's "(" remove it
            }

            // If it is an operator
            else if (tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("^")) {

                // while not (top is of lower precedence than t OR
                // t is right associative and top is of equal precedence)
                while (!s.isEmpty() && !(s.peek().equals("(")) && prec(tokens[i]) <= prec(s.peek())) {
                    r = r + " " + s.pop();
                }
                s.push(tokens[i]); //otherwise push the opperator
            } else  { // If t is an operand, r = r + t;
                r = r + " " + tokens[i];
            }
            i++;
        }

        // while stack not empty
        while (!s.isEmpty()) {
            r = r + " " + s.pop();
        }
        return r.trim();
    }

    /**
     * Helper methods evaluates operator precedence
     * @param x	Sting holding the operator to check
     * @return	The value of precedence
     */
    static int prec(String x) {
        if (x.equals("+") || x.equals("-"))
            return 1;
        if (x.equals("*") || x.equals("/"))
            return 2;
        if (x.equals("^"))
            return 3;
        return 0;
    }
}