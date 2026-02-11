package edu.ntnu.idi.idatt2003;

/**
 * Text command that capitalizes the first character of every word.
 * Word boundaries are defined by whitespace.
 */
public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {

    /**
     * Capitalizes the first character of every word in the text.
     *
     * @param text the text to process
     * @return the text with the first character of each word capitalized
     * @throws IllegalArgumentException if text is null
     */
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (text.isEmpty()) {
            return text;
        }
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c)) {
                result.append(c);
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}
