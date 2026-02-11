package edu.ntnu.idi.idatt2003;

public class CapitalizeTextCommand implements TextCommand {
    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        int len = text.length();
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < len; i++) {
            char c = sb.charAt(i);
            if (!Character.isWhitespace(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
                break;
            }
        }
        return sb.toString();
    }
}
