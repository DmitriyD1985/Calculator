import java.util.*;

public class Calculate {
    public static Double calc(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<Double>();

        for (String x : postfix) {
            if (x.equals("^")) {
                double exponent = stack.pop();
                double base = stack.pop();
                stack.push(Math.pow(base, exponent));
            } else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (x.equals("-")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            } else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (x.equals("/")) {
                Double b = stack.pop(), a = stack.pop();
                if (b == 0) {
                    throw new ArithmeticException("Делить на ноль нельзя");
                } else {
                    stack.push(a / b);
                }
            } else if (x.equals("u-")) stack.push(-stack.pop());
            else stack.push(Double.valueOf(x));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        StringParser n = new StringParser();
        List<String> expression = null;
        String intput = ConsoleInput.readConsole();
        if (intput != null) {
            expression = n.parse(intput);
            boolean flag = n.flag;
            if (flag) {
                System.out.println();
                System.out.println(calc(expression));
            }
        }
        else System.out.println("Перезапустите программу!");
    }
}
