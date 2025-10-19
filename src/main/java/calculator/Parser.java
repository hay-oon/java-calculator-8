package calculator;

public class Parser {
    
    public static String[] parseNumbers(String input) {
        if (input.isEmpty() || input.trim().isEmpty()) {
            return new String[0];
        }
        if (input.startsWith("//")) {
            int customDelimiterIndex = input.indexOf("\\n");
            
            String customDelimiter = input.substring(2, customDelimiterIndex);
            String numbersPart = input.substring(customDelimiterIndex + 2);
            return numbersPart.trim().split(customDelimiter);
        } else {
            return input.trim().split("[,\\:]+");
        }
    }
}