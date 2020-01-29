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
        int counSpace=0;
        if (!s.isEmpty()) {
            for (String m : inputArr) {
                if (!allowedSymbols.contains(m)) {
                    System.out.println("Вы ввели недопустимы символ, повторите ввод");
                    return null;
                }
                if(m.equals(" ")){counSpace++;}
            }
            if(counSpace==s.length())
            {
                System.out.println("Вы ввели только пробелы");
                return null;
            }
        }
        else {
            System.out.println("Вы ничего не ввели");
            return null;
        }
         if (s.indexOf(')') < (s.indexOf('('))) {
            System.out.println("Вы ввели выражение с неверным порядком скобок, повторите ввод");
            return null;
        } else if (s.contains("()")) {
            System.out.println("Вы ввели пустые скобки, повторите ввод");
            return null;
        }
        in.close();
        return s;
    }
}
