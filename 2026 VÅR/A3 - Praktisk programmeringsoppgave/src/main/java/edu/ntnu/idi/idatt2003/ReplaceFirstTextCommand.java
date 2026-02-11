package edu.ntnu.idi.idatt2003;

/**
 * Text command that replaces only the first occurrence of a target string.
 */
public class ReplaceFirstTextCommand extends ReplaceTextCommand {

    /**
     * Creates a new ReplaceFirstTextCommand.
     *
     * @param target the string to replace
     * @param replacement the replacement string
     * @throws NullPointerException if target or replacement is null
     */
    public ReplaceFirstTextCommand(String target, String replacement) {
        super(target, replacement);
    }

    /**
     * Replaces only the first occurrence of the target string with the replacement string.
     *
     * @param text the text to process
     * @return the text with the first occurrence replaced
     * @throws IllegalArgumentException if text is null
     */
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        String target = getTarget();
        String replacement = getReplacement();
        int index = text.indexOf(target);
        if (index == -1) {
            return text;
        }
        return text.substring(0, index) + replacement + text.substring(index + target.length());
    }
}
