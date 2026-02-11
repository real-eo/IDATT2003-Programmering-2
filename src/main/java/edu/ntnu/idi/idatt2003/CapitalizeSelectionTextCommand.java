package edu.ntnu.idi.idatt2003;

import java.util.Objects;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {
    private final String selection;

    public CapitalizeSelectionTextCommand(String selection) {
        this.selection = Objects.requireNonNull(selection, "selection must not be null");
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        if (selection.isEmpty()) return text;
        // Capitalize the selection (first non-space letter inside selection)
        String capitalized = new CapitalizeTextCommand().execute(selection);
        return text.replace(selection, capitalized);
    }
}
