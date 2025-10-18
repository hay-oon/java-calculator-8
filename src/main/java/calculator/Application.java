package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // input 에서 구분자로 문자열을 나누는 메서드
        String[] ExtractedNumber = ExtractNumber(input);
        // 올바른 숫자 값인지 검증하는 메서드
        ValidateInput(ExtractedNumber);
        // 숫자들의 합을 계산하는 메서드
        int sum = CalculateSum(ExtractedNumber);
        System.out.println("결과 : " + sum);
    }

    public static String[] ExtractNumber(String input) {
        if (input.isEmpty()) {
            return new String[] {"0"};
        }
        if (input.startsWith("//")) {
            // 1. 개행문자 위치 찾기 (테스트용 \\n과 실제 \n 둘 다 확인 해야함)
            int newlineIndex = input.indexOf("\\n");  // 테스트 코드에서 사용하는 \\n 먼저 확인
            if (newlineIndex == -1) {
                newlineIndex = input.indexOf("\n");  // 실제 개행문자 확인
            }
            
            // 2. 개행문자가 없으면 예외 발생
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            
            // 3. 숫자 부분 추출 (개행문자 이후 부분)
            // \\n은 2글자, \n은 1글자이므로 적절한 오프셋 계산
            String numbers = input.substring(newlineIndex + (input.contains("\\n") ? 2 : 1));
            
            // 4. 커스텀 구분자 추출 ("//"와 개행문자 사이)
            String CustomDelimeter = input.substring(2, newlineIndex);
            
            // 5. 커스텀 구분자로 숫자들 분리
            String [] ExtractedNumber = numbers.trim().split(CustomDelimeter);
            return ExtractedNumber;
        }
        String [] ExtractedNumber = input.trim().split("[,\\:]+");
        return ExtractedNumber;
    }

    public static void ValidateInput (String[] ExtractedNumber) {
            // 숫자가 아닌 문자가 포함되어 있는지 검증
            for (String number : ExtractedNumber) {
                if (!number.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("숫자가 아닙니다.");
                }   
            // 음수 검증
                if (Integer.parseInt(number) < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
            }
    }

    public static int CalculateSum (String[] ExtractedNumber) {
        int sum = 0;
        for (String number : ExtractedNumber) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}