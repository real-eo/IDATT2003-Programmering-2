package edu.ntnu.idi.idatt2003;

import java.util.Objects;

/**
 * Text command that capitalizes all occurrences of a selection.
 */
public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {
    private final String selection;

    /**
     * Creates a new CapitalizeSelectionTextCommand.
     *
     * @param selection the selection to capitalize
     * @throws NullPointerException if selection is null
     */
    public CapitalizeSelectionTextCommand(String selection) {
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
     * Replaces all occurrences of the selection with a capitalized version.
     * Empty selection results in no operation.
     *
     * @param text the text to process
     * @return the text with all occurrences of selection capitalized
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
        
        String capitalized = super.execute(selection);
        return text.replace(selection, capitalized);
    }
}
