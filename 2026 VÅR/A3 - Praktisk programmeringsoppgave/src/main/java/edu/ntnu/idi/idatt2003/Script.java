package edu.ntnu.idi.idatt2003; 
 
import java.util.Collections; 
import java.util.List; 
import java.util.Objects; 
 
/** 
 * A script that executes a sequence of text commands. 
 */ 
public class Script { 
    private final List<TextCommand> commands; 
 
    /** 
     * Creates a new Script. 
     * 
     * @param commands the list of commands to execute 
     * @throws NullPointerException if commands is null 
     */ 
    public Script(List<TextCommand> commands) { 
        this.commands = Objects.requireNonNull(commands, "Commands cannot be null"); 
    } 
 
    /** 
     * Gets the list of commands. 
     * 
     * @return the list of commands 
     */ 
    public List<TextCommand> getCommands() { 
        return Collections.unmodifiableList(commands); 
    } 
 
    /** 
     * Executes all commands in order, passing the result of each command to the next. 
     * 
     * @param text the initial text to process 
     * @return the final processed text 
     * @throws IllegalArgumentException if text is null 
     */ 
    public String execute(String text) { 
        if (text == null) { 
            throw new IllegalArgumentException("Text cannot be null"); 
        } 
        String result = text; 
        for (TextCommand command : commands) { 
            result = command.execute(result); 
        } 
        return result; 
    } 
} 
