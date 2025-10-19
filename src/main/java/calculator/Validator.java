package calculator;

public class Validator {
    
    public static void validateInput(String input) {
        if (input.startsWith("//")) {
            int customDelimiterIndex = input.indexOf("\\n");
            
            if (customDelimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            
            String customDelimiter = input.substring(2, customDelimiterIndex);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }
        }
    }
    
    public static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다. '" + number + "'");
            }
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다. '" + number + "'");
            }
        }
    }
}
