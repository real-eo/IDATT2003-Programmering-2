package edu.ntnu.idi.idatt2003;

import java.util.Objects;

/**
 * Text command that wraps text with an opening and ending string.
 */
public class WrapTextCommand implements TextCommand {
    private final String opening;
    private final String end;

    /**
     * Creates a new WrapTextCommand.
     *
     * @param opening the opening string
     * @param end the ending string
     * @throws NullPointerException if opening or end is null
     */
    public WrapTextCommand(String opening, String end) {
        this.opening = Objects.requireNonNull(opening, "Opening cannot be null");
        this.end = Objects.requireNonNull(end, "End cannot be null");
    }

    /**
     * Gets the opening string.
     *
     * @return the opening string
     */
    public String getOpening() {
        return opening;
    }

    /**
     * Gets the ending string.
     *
     * @return the ending string
     */
    public String getEnd() {
        return end;
    }

    /**
     * Wraps the text with the opening and ending strings.
     *
     * @param text the text to wrap
     * @return the wrapped text
     * @throws IllegalArgumentException if text is null
     */
    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return opening + text + end;
    }
}
