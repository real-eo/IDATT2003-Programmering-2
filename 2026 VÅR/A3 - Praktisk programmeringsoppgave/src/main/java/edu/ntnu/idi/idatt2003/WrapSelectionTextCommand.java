package edu.ntnu.idi.idatt2003; 
 
import java.util.Objects; 
 
/** 
 * Text command that wraps all occurrences of a selection with an opening and ending string. 
 */ 
public class WrapSelectionTextCommand extends WrapTextCommand { 
    private final String selection; 
 
    /** 
     * Creates a new WrapSelectionTextCommand. 
     * 
     * @param opening the opening string 
     * @param end the ending string 
     * @param selection the selection to wrap 
     * @throws NullPointerException if opening, end, or selection is null 
     */ 
    public WrapSelectionTextCommand(String opening, String end, String selection) { 
        super(opening, end); 
        this.selection = Objects.requireNonNull(selection, "Selection cannot be null"); 
    } 
 
    /** 
     * Gets the selection string. 
     * 
     * @return the selection string 
     */ 
    public String getSelection() { 
        return selection; 
    } 
 
    /** 
     * Wraps all occurrences of the selection with the opening and ending strings. 
     * Empty selection results in no operation. 
     * 
     * @param text the text to process 
     * @return the text with all occurrences of selection wrapped 
     * @throws IllegalArgumentException if text is null 
     */ 
    @Override 
    public String execute(String text) { 
        if (text == null) { 
            throw new IllegalArgumentException("Text cannot be null"); 
        } 
        if (selection.isEmpty()) { 
            return text; 
        } 
        return text.replace(selection, getOpening() + selection + getEnd()); 
    } 
} 
