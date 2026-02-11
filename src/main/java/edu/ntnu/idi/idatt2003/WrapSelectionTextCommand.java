package edu.ntnu.idi.idatt2003;

import java.util.Objects;

public class WrapSelectionTextCommand extends WrapTextCommand {
    private final String selection;

    public WrapSelectionTextCommand(String opening, String end, String selection) {
        super(Objects.requireNonNull(opening), Objects.requireNonNull(end));
        this.selection = Objects.requireNonNull(selection, "selection must not be null");
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        if (selection.isEmpty()) return text;
        String wrapped = getOpening() + selection + getEnd();
        return text.replace(selection, wrapped);
    }
}
