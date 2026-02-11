package edu.ntnu.idi.idatt2003;

import java.util.Objects;

public class WrapLinesTextCommand extends WrapTextCommand {
    public WrapLinesTextCommand(String opening, String end) {
        super(Objects.requireNonNull(opening), Objects.requireNonNull(end));
    }

    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        String[] lines = text.split("\n", -1); // keep trailing empty lines
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            sb.append(getOpening()).append(lines[i]).append(getEnd());
            if (i < lines.length - 1) sb.append('\n');
        }
        return sb.toString();
    }
}
