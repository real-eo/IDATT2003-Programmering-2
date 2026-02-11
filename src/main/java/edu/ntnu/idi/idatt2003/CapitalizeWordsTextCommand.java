package edu.ntnu.idi.idatt2003;

public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {
    @Override
    public String execute(String text) {
        if (text == null) throw new IllegalArgumentException("text must not be null");
        StringBuilder sb = new StringBuilder(text);
        boolean capitalizeNext = true;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                sb.setCharAt(i, Character.toUpperCase(c));
                capitalizeNext = false;
            }
        }
        return sb.toString();
    }
}
