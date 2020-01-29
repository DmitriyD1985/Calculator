import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInput {
    public static String readConsole() {
        System.out.println("Введите выраженение для вычисления. В выражении должны быть только цифры, скобки и математические знаки (+-*/^)");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String allowedSymbols = "0123456789()^/*+- .";
        String[] inputArr = s.split("");
        for (String m : inputArr) {
            if (!allowedSymbols.contains(m)) {
                System.out.println("Вы ввели недопустимы символ, повторите ввод");
                readConsole();
            }
        }
        if (s.indexOf(')') < (s.indexOf('('))) {
            System.out.println("Вы ввели выражение с неверным порядком скобок, повторите ввод");
            readConsole();
        } else if (s.contains("()")) {
            System.out.println("Вы ввели пустые скобки, повторите ввод");
            readConsole();
        }
        in.close();
        return s;
    }
}
