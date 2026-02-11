package edu.ntnu.idi.idatt2003;

import java.util.Objects;

public class WrapTextCommand implements TextCommand {
    private final String opening;
    private final String end;

    public WrapTextCommand(String opening, String end) {
        this.opening = Objects.requireNonNull(opening, "opening must not be null");
        this.end = Objects.requireNonNull(end, "end must not be null");
    }

    public String getOpening() {
        return opening;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        return opening + text + end;
    }
}
