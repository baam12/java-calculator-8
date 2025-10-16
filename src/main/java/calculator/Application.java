package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if(input == null || input.isEmpty()) {
            String inputBlank = "0";
            System.out.println("결과 : " + inputBlank);
        } else {
            String[] inputSplit = input.split("[,:]");

            System.out.println(Arrays.toString(inputSplit));

            int sum = 0;
            for (String p : inputSplit) {
                sum += Integer.parseInt(p);
            }

            System.out.println("결과 : " + sum);
        }
    }
}
