import java.util.*;

public class Calculate {
    public static Double calc(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<Double>();
        for (String x : postfix) {
            if (x.equals("^")) stack.push(Math.pow(stack.pop(), stack.pop()));
            else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
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
        System.out.println("Введите выраженение для вычисления. В выражении должны быть только цифры, скобки и математические знаки (+-*/^)");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringParser n = new StringParser();
        List<String> expression = null;
        try {
            expression = n.parse(s);
            boolean flag = n.flag;
            if (flag) {
                System.out.println();
                System.out.println(calc(expression));
            }
        } catch (NullPointerException e) {
            System.out.println("В введенном Вами выражении ошибка (скобки не согласованы)");
        }
        catch ( NoSuchElementException e) {
            System.out.println("В введенном Вами выражении ошибка (недопустимы математический знак)");
        }
        catch (NumberFormatException e) {
            System.out.println("В введенном Вами выражении ошибка (присутствуют буквы)");
        }
        catch (ArithmeticException e) {
            System.out.println("В введенном Вами выражении ошибка (деление на 0)");
        }
    }
}
