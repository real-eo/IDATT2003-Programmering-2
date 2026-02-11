package edu.ntnu.idi.idatt2003;

import java.util.Objects;

public class ReplaceTextCommand implements TextCommand {
    private final String target;
    private final String replacement;

    public ReplaceTextCommand(String target, String replacement) {
        this.target = Objects.requireNonNull(target, "target must not be null");
        this.replacement = Objects.requireNonNull(replacement, "replacement must not be null");
    }

    public String getTarget() {
        return target;
    }

    public String getReplacement() {
        return replacement;
    }

    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        return text.replace(target, replacement);
    }
}
