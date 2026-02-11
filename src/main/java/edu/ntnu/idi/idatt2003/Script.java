package edu.ntnu.idi.idatt2003;

import java.util.List;
import java.util.Objects;

public class Script {
    private final List<TextCommand> commands;

    public Script(List<TextCommand> commands) {
        this.commands = Objects.requireNonNull(commands, "commands must not be null");
    }

    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        String current = text;
        for (TextCommand cmd : commands) {
            current = cmd.execute(current);
        }
        return current;
    }

    public List<TextCommand> getCommands() {
        return commands;
    }
}
