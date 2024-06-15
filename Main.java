import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выведите математическое выражение: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            String result = calc(input);
            System.out.printf("Результат выполнения выражения: %s\n", result);
        } catch (Exception e) {
            System.out.printf("Не удалось выполнить выражение! %s", e);
        }
    }

    public static String calc(String input) throws Exception {
        // Метод для вычисления выражения
        String[] arguments = input.split(" ");
        if (arguments.length > 3 || arguments.length < 3) {
            throw new Exception("Неверный формат операции!\n");
        }

        String num1 = arguments[0];
        String operator = arguments[1];
        String num2 = arguments[2];

        if (checkRomeIntegers(num1) && checkRomeIntegers(num2)) {
            Integer numInt1 = romeToInteger(num1);
            Integer numInt2 = romeToInteger(num2);
            if (numInt1 == 0 || numInt2 == 0) {
                throw new Exception("Используется неправильное значение числа!\n");
            } else if (numInt1 > 10 || numInt2 > 10) {
                throw new Exception("Используется неправильное значение числа!\n");
            }

            Integer result = calcProcessing(numInt1, numInt2, operator);

            if (result < 0) {
                throw new Exception("В римских числах нет отрицательных чисел!\n");
            } else if (result == 0) {
                throw new Exception("В римских числах нет нуля!\n");
            }

            String romeResultOut = integerToRome(result);
            return romeResultOut;
        } else if (checkRomeIntegers(num1) || checkRomeIntegers(num2)) {
            throw new Exception("Используется неправильное значение числа!\n");
        } else {
            Integer numInt1 = Integer.valueOf(num1);
            Integer numInt2 = Integer.valueOf(num2);
            if (numInt1 == 0 || numInt2 == 0) {
                throw new Exception("Используется неправильное значение числа!\n");
            } else if (numInt1 > 10 || numInt2 > 10) {
                throw new Exception("Используется неправильное значение числа!\n");
            }

            Integer result = calcProcessing(numInt1, numInt2, operator);
            String intResult = Integer.toString(result);
            return intResult;
        }
    }

    public static Integer calcProcessing(Integer numInt1, Integer numInt2, String operator) throws Exception {
        // Метод для вычисления выражения
        int result = 0;
        switch (operator) {
            case "+": result = numInt1 + numInt2;
                break;
            case "-": result = numInt1 - numInt2;
                break;
            case "*": result = numInt1 * numInt2;
                break;
            case "/": result = numInt1 / numInt2;
                break;
            case "%": throw new Exception("Неправильное математическое выражение или операнд!\n");
        }
        return result;
}

    public static Boolean checkRomeIntegers(String input) {
        // Метод для проверки есть ли в выражении римские числа
        // Сделал более оптимально
        String[] numbers = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for(String n: numbers) {
            if (n.equals(input)) {
                return true;
            }
        }
        return false;
    }   

    public static Integer romeToInteger(String rome) {
        // Метод для преобразования римских чисел в обычные
        int result = 0;
        switch (rome) {
            case "I": result = 1;
                break;
            case "II": result = 2;
                break;
            case "III": result = 3;
                break;
            case "IV": result = 4;
                break;
            case "V": result = 5;
                break;
            case "VI": result = 6;
                break;
            case "VII": result = 7;
                break;
            case "VIII": result = 8;
                break;
            case "IX": result = 9;
                break;
            case "X": result = 10;
                break;
        }
        return result;
    }

    public static String integerToRome(Integer num) {
        // Метод для преобразования обычных чисел в римские
        String out = "";
        switch (num) {
            case 1: out = "I";
                break;
            case 2: out = "II";
                break;
            case 3: out = "III";
                break;
            case 4: out = "VI";
                break;
            case 5: out = "V";
                break;
            case 6: out = "VI";
                break;
            case 7: out = "VII";
                break;
            case 8: out = "VIII";
                break;
            case 9: out = "IX";
                break;
            case 10: out = "X";
                break;
        }
        return out;
    }
}
