package test_calc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");

        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("Output: " + e.getMessage());
        }
    }

    public static String calc(String input) {

        String[] parts = getParts(input);

        int num1 = parseOperand(parts[0]);
        String operator = parts[1];
        int num2 = parseOperand(parts[2]);

        int result;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Некорректный оператор");
        }

        return String.valueOf(result);
    }

    private static String[] getParts(String input) {
        String[] parts = input.split("\\s+");

        if (parts.length != 3) {
            if (parts.length == 1) {
                throw new IllegalArgumentException("throws Exception//т.к. строка не является математической операцией");
            } else if (parts.length > 4) {
                throw new IllegalArgumentException("throws Exception//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else if (parts.length > 3){
                throw new IllegalArgumentException("throws Exception");
            }
        }
        return parts;
    }

    private static int parseOperand(String operand) {
        int num;
        try {
            num = Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный операнд: " + operand);
        }

        if (num < 1 || num > 10) {
            throw new IllegalArgumentException("Число должно быть от 1 до 10 включительно");
        }

        return num;
    }
}
