import java.util.Scanner;

public class ConsoleInput {
    public static String readConsole() {
        System.out.println("Введите выраженение для вычисления. В выражении должны быть только цифры, скобки и математические знаки (+-*/^)");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String allowedSymbols = "0123456789()^/*+- .";
        String[] inputArr = s.split("");
        int countSpace = 0;
        if (!s.isEmpty()) {
            for (String m : inputArr) {
                if (!allowedSymbols.contains(m)) {
                    System.out.println("Вы ввели недопустимы символ, повторите ввод");
                    return null;
                }
                if (m.equals(" ")) {
                    countSpace++;
                }
            }

            if (!bracketChekcer(s)) {
                System.out.println("Cкобки не согласованы");
                return null;
            }
            if (countSpace == s.length()) {
                System.out.println("Вы ввели только пробелы");
                return null;
            }
        } else {
            System.out.println("Вы ничего не ввели");
            return null;
        }

        if (s.contains("()")) {
            System.out.println("Вы ввели пустые скобки, повторите ввод");
            return null;
        }
        in.close();
        return s;
    }

    public static boolean bracketChekcer(String input) {
        StringBuilder sb = new StringBuilder();
        String[] arrFromInput = input.split("");
        for (String s : arrFromInput) {
            if (s.equalsIgnoreCase(")") || s.equalsIgnoreCase("(")) {
                sb.append(s);
            }
        }
        String bracketString = sb.toString();
        int bracketCount = bracketString.length() / 2;
        if (bracketCount == 0) {
            return true;
        } else if (bracketString.length() % 2 != 0) {
            return false;
        } else {
            String totalString;
            char[] arr = bracketString.toCharArray();
            for (int i = 0; i < bracketCount; i++) {
                // не очень удачный способ, так как строка imutable, но другого найти пока не могу
                bracketString = bracketString.replaceAll("\\(\\)", "");
            }
            return bracketString.isEmpty();
        }
    }
}

