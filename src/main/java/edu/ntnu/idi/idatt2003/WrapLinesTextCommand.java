package edu.ntnu.idi.idatt2003;

/**
 * Text command that wraps each line with an opening and ending string.
 */
public class WrapLinesTextCommand extends WrapTextCommand {

    /**
     * Creates a new WrapLinesTextCommand.
     *
     * @param opening the opening string
     * @param end the ending string
     * @throws NullPointerException if opening or end is null
     */
    public WrapLinesTextCommand(String opening, String end) {
        super(opening, end);
    }

    /**
     * Wraps each line with the opening and ending strings.
     * Lines are split on '\n' and trailing empty lines are preserved.
     *
     * @param text the text to process
     * @return the text with each line wrapped
     * @throws IllegalArgumentException if text is null
     */
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        String[] lines = text.split("\n", -1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i > 0) {
                result.append("\n");
            }
            result.append(getOpening()).append(lines[i]).append(getEnd());
        }
        return result.toString();
    }
}
