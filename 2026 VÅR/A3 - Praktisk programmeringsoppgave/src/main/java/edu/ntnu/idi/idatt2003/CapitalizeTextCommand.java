package edu.ntnu.idi.idatt2003; 
 
/** 
 * Text command that capitalizes the first non-whitespace character in the text. 
 */ 
public class CapitalizeTextCommand implements TextCommand { 
 
    /** 
     * Capitalizes the first non-whitespace character in the text. 
     * 
     * @param text the text to process 
     * @return the text with the first non-whitespace character capitalized 
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
         
        for (int i = 0; i < text.length(); i++) { 
            char c = text.charAt(i); 
            if (!Character.isWhitespace(c)) { 
                return text.substring(0, i) + Character.toUpperCase(c) + text.substring(i + 1); 
            } 
        } 
        return text; 
    } 
} 
