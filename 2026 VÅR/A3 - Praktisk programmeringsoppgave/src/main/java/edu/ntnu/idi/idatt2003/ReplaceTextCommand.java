package edu.ntnu.idi.idatt2003; 
 
import java.util.Objects; 
 
/** 
 * Text command that replaces all occurrences of a target string with a replacement string. 
 */ 
public class ReplaceTextCommand implements TextCommand { 
    private final String target; 
    private final String replacement; 
 
    /** 
     * Creates a new ReplaceTextCommand. 
     * 
     * @param target the string to replace 
     * @param replacement the replacement string 
     * @throws NullPointerException if target or replacement is null 
     */ 
    public ReplaceTextCommand(String target, String replacement) { 
        this.target = Objects.requireNonNull(target, "Target cannot be null"); 
        this.replacement = Objects.requireNonNull(replacement, "Replacement cannot be null"); 
    } 
 
    /** 
     * Gets the target string. 
     * 
     * @return the target string 
     */ 
    public String getTarget() { 
        return target; 
    } 
 
    /** 
     * Gets the replacement string. 
     * 
     * @return the replacement string 
     */ 
    public String getReplacement() { 
        return replacement; 
    } 
 
    /** 
     * Replaces all occurrences of the target string with the replacement string. 
     * 
     * @param text the text to process 
     * @return the text with all occurrences replaced 
     * @throws IllegalArgumentException if text is null 
     */ 
    @Override 
    public String execute(String text) { 
        if (text == null) { 
            throw new IllegalArgumentException("Text cannot be null"); 
        } 
        return text.replace(target, replacement); 
    } 
} 
