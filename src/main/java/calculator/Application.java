package calculator;

import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        String[] tokens;

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\n");

            String customDelimiter;
            String numbers;

            if (newLineIndex >= 0) {
                customDelimiter = input.substring(2, newLineIndex);
                numbers = input.substring(newLineIndex + 1);
            } else {
                customDelimiter = input.substring(2);
                String secondLine = Console.readLine();
                if (secondLine == null) throw new IllegalArgumentException();
                numbers = secondLine;
            }

            if (customDelimiter.isEmpty() || customDelimiter.isBlank()) throw new IllegalArgumentException();
            if (customDelimiter.matches("-?\\d+")) throw new IllegalArgumentException();

            tokens = numbers.split(Pattern.quote(customDelimiter), -1);
        } else {
            tokens = input.split("[,:]", -1);
        }

        int sum = 0;
        for (String raw : tokens) {
            if (raw == null) throw new IllegalArgumentException();
            String token = raw.trim();
            if (token.isEmpty()) throw new IllegalArgumentException();

            final int number;
            try {
                number = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (number <= 0) throw new IllegalArgumentException();

            sum += number;
        }
        System.out.println("결과 : " + sum);
    }
}
