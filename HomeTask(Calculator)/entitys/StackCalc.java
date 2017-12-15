package homeWorks.calculator.entitys;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Calculator work with two stacks operations and operands
 *
 * @author Jesus Raichuk
 */
public class StackCalc {
    private static int pos;
    private static Map<String, String> myOperations;

    static {
        nullifyInitialValues();
        takeMyOperations();
    }

    public static double process(String getS) throws IllegalArgumentException, EmptyStackException {

        getS = giveAMask(getS);

        getS = '(' + getS + ')';
        Stack<Double> operands = new Stack<>();
        Stack<Character> operations = new Stack<>();
        Object token;
        Object prevToken = 'X';

        do {
            token = getToken(getS);

            if (isUnaryPlusOrMinus(token, prevToken))
                operands.push(0.0);

            if (token instanceof Double)
                operands.push((double) token);

            else if (token instanceof Character) {
                if ((char) token == ')') {
                    while (operations.size() > 0 && operations.peek() != '(')
                        popOperation(operands, operations);
                    operations.pop(); // delete "("
                } else {
                    while (canPop((char) token, operations))
                        popOperation(operands, operations);

                    operations.push((char) token);
                }
            }
            prevToken = token;
        }
        while (token != null);

        if (operands.size() > 1 || operations.size() > 0)
            throw new IllegalArgumentException("Incorrect arrangement of operands and operations.");

        nullifyInitialValues();
        return operands.pop();
    }
    /**
     * Po these operation
     * @param operands - stack of operands
     * @param operations - stack of operations
     */
    private static void popOperation(Stack<Double> operands, Stack<Character> operations) {
        double b = operands.pop();
        double a;
        switch (operations.pop()) {
            case '+':
                a = operands.pop();
                operands.push(a + b);
                break;
            case '-':
                a = operands.pop();
                operands.push(a - b);
                break;
            case '*':
                a = operands.pop();
                operands.push(a * b);
                break;
            case '/':
                a = operands.pop();
                operands.push(a / b);
                break;
            //sin
            case 's':
                operands.push(Math.sin(b));
                break;
            //cos
            case 'c':
                operands.push(Math.cos(b));
                break;
        }
    }
    /**
     * Can pop or not
     * @param op1 - will check
     * @param operations - stack
     * @return boolean - can or not
     */
    private static boolean canPop(char op1, Stack<Character> operations) {
        if (operations.size() == 0)
            return false;
        int pr1 = getPriority(op1);
        int pr2 = getPriority(operations.peek());
        return pr1 >= 0 && pr2 >= 0 && pr1 >= pr2;
    }
    /**
     * Get the priority of operations
     * @param operation - operation we need priority
     * @return int - priority of operation
     * @throws IllegalArgumentException - if operation is not correct
     */
    private static int getPriority(char operation) throws IllegalArgumentException {
        switch (operation) {
            case '(':
                //Does not push himself out and does not allow to be pushed out
                return -1;
            case '*':
            case '/':
            case 's':
            case 'c':
                return 1;
            case '+':
            case '-':
                return 2;
            default:
                throw new IllegalArgumentException("Error operation!!!");
        }
    }
    /**
     * Take the token and do operation one is
     * @param getS - all string
     * @return processed token - operation or double digit or null
     */
    private static Object getToken(String getS) {
        readToChar(getS);
        //End of the string
        if (pos == getS.length())
            return null;
        if (Character.isDigit(getS.charAt(pos)))
            return Double.parseDouble(makeDouble(getS));
        else
            return readOperation(getS);
    }
    /**
     * Read double digit
     * @param getS - all string
     * @return String - double digit
     */
    private static String makeDouble(String getS) {
        String res = "";
        while (pos < getS.length() && (Character.isDigit(getS.charAt(pos)) || getS.charAt(pos) == '.'))
            res += getS.charAt(pos++);

        return res;
    }
    /**
     * Read to first valid symbol
     * @param getS - all string
     */
    private static void readToChar(String getS) {
        while (pos < getS.length() && getS.charAt(pos) == ' ')
            pos++;
    }
    /**
     * Read operation one-symbol
     * @param getS - all string
     * @return char - one-symbol (operation)
     */
    private static char readOperation(String getS) {
        return getS.charAt(pos++);
    }
    /**
     * Check symbol to unary add or sub operation
     * @param token - symbol
     * @param prevToken - preview symbol
     * @return boolean - unary or not
     */
    private static boolean isUnaryPlusOrMinus(Object token, Object prevToken) {
        return (token instanceof Character &&
                prevToken instanceof Character &&
                (char) prevToken == '(' &&
                ((char) token == '+' || (char) token == '-'));
    }

    private static void nullifyInitialValues() {
        pos = 0;
    }
    /**
     * Create Map for my operations
     */
    private static void takeMyOperations() {
        myOperations = new HashMap<>();
        myOperations.put("sin", "s");
        myOperations.put("cos", "c");
    }
    /**
     * Transfer operation to mask
     * @param op - operation
     * @return String - mask
     */
    private static String giveAMask(String op) {
        for (String key : myOperations.keySet()) {
            op = op.replace(key, myOperations.get(key));
        }
        return op;
    }
}
