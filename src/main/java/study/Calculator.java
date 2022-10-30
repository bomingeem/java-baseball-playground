package study;

public class Calculator {
    public static String[] operationType = {"+", "-", "*", "/"};

    public int inputAndStart(String value) {
        String[] values = getSplitString(value);
        int result = parsingToInteger(values[0]);
        String operator = "";

        for (int i=1; i<values.length; i++) {
            if (isOperationType(values[i])) {
                operator = values[i];
            } else {
                result = calculate(result, operator, values[i]);
            }
        }
        return result;
    }

    public boolean isOperationType(String input) {
        for (String operator : operationType) {
            if (input.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public int calculate(int result, String operator, String number) {
        isNullOrEmpty(number);
        switch (operator) {
            case "+":
                return add(result, parsingToInteger(number));
            case "-":
                return subtract(result, parsingToInteger(number));
            case "*":
                return multiply(result, parsingToInteger(number));
            case "/":
                return divide(result, parsingToInteger(number));
            default:
                throw new IllegalArgumentException();
        }
    }

    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        return i / j;
    }

    private void isNullOrEmpty(String number) {
        if (number == null || number.equals("")) throw new IllegalArgumentException();
    }

    private String[] getSplitString(String value) {
        String[] values = value.split(" ");
        return values;
    }

    private int parsingToInteger(String value) {
        return Integer.parseInt(value);
    }
}
