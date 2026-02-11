package edu.ntnu.idi.idatt2003;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TextCommandsTest {
    @Test
    public void replaceAllExample() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("target", "replacement");
        assertEquals("text with replacement and replacement", cmd.execute("text with target and target"));
    }

    @Test
    public void replaceFirstExample() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("target", "replacement");
        assertEquals("text with replacement and target", cmd.execute("text with target and target"));
    }

    @Test
    public void wrapExample() {
        WrapTextCommand cmd = new WrapTextCommand("<p>", "</p>");
        assertEquals("<p>text to be wrapped</p>", cmd.execute("text to be wrapped"));
    }

    @Test
    public void wrapLinesExample() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("<p>", "</p>");
        assertEquals("<p>first line</p>\n<p>second line</p>", cmd.execute("first line\nsecond line"));
    }

    @Test
    public void wrapSelectionExample() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<p>", "</p>", "selection");
        assertEquals("text with <p>selection</p>", cmd.execute("text with selection"));
    }

    @Test
    public void capitalizeExample() {
        CapitalizeTextCommand cmd = new CapitalizeTextCommand();
        assertEquals("Text to be caplitalized", cmd.execute("text to be caplitalized"));
    }

    @Test
    public void capitalizeWordsExample() {
        CapitalizeWordsTextCommand cmd = new CapitalizeWordsTextCommand();
        assertEquals("Text To Be Capitalized", cmd.execute("text to be capitalized"));
    }

    @Test
    public void capitalizeSelectionExample() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("selection");
        assertEquals("text with Selection and another Selection", cmd.execute("text with selection and another selection"));
    }

    @Test
    public void scriptExample() {
        Script script = new Script(Arrays.asList(
                new ReplaceTextCommand("foo", "bar"),
                new WrapTextCommand("<p>", "</p>")
        ));
        assertEquals("<p>bar baz</p>", script.execute("foo baz"));
    }

    @Test
    public void nullTextThrows() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("a", "b");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }
}
