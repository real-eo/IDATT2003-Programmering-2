package edu.ntnu.idi.idatt2003; 
 
/** 
 * Interface for text commands. 
 */ 
public interface TextCommand { 
    /** 
     * Execute the command on the given text. 
     * 
     * @param text the text to process 
     * @return the processed text 
     */ 
    String execute(String text); 
} 
