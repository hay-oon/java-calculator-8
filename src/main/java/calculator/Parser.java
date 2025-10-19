package calculator;

public class Parser {
    
    public static String[] parseNumbers(String input) {
        String[] numbers;
        
        if (input.startsWith("//")) {
            int customDelimiterIndex = input.indexOf("\\n");
            
            String customDelimiter = input.substring(2, customDelimiterIndex);
            String numbersPart = input.substring(customDelimiterIndex + 2);
            numbers = numbersPart.trim().split(customDelimiter);
        } else {
            numbers = input.trim().split("[,\\:]+");
        }
        
        // 각 숫자에서 공백 제거
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }
        
        return numbers;
    }
}