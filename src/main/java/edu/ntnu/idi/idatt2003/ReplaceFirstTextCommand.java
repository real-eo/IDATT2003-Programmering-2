package edu.ntnu.idi.idatt2003;

import java.util.Objects;

public class ReplaceFirstTextCommand extends ReplaceTextCommand {
    public ReplaceFirstTextCommand(String target, String replacement) {
        super(Objects.requireNonNull(target), Objects.requireNonNull(replacement));
    }

    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        String target = getTarget();
        int idx = text.indexOf(target);
        if (idx < 0) return text;
        StringBuilder sb = new StringBuilder();
        sb.append(text, 0, idx);
        sb.append(getReplacement());
        sb.append(text, idx + target.length(), text.length());
        return sb.toString();
    }
}
