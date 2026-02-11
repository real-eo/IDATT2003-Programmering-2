package edu.ntnu.idi.idatt2003;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for text commands.
 */
class TextCommandsTest {

    @Test
    void testReplaceTextCommand() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("world", "Java");
        assertEquals("Hello Java!", cmd.execute("Hello world!"));
        assertEquals("Java Java", cmd.execute("world world"));
        assertEquals("no match", cmd.execute("no match"));
        assertEquals("", cmd.execute(""));
    }

    @Test
    void testReplaceTextCommandNullInput() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("a", "b");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testReplaceFirstTextCommand() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("a", "X");
        assertEquals("Xbc abc", cmd.execute("abc abc"));
        assertEquals("no mtch", cmd.execute("no mtch"));
        assertEquals("", cmd.execute(""));
    }

    @Test
    void testReplaceFirstTextCommandNullInput() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("a", "b");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testWrapTextCommand() {
        WrapTextCommand cmd = new WrapTextCommand("[", "]");
        assertEquals("[Hello]", cmd.execute("Hello"));
        assertEquals("[]", cmd.execute(""));
        assertEquals("[test\nline]", cmd.execute("test\nline"));
    }

    @Test
    void testWrapTextCommandNullInput() {
        WrapTextCommand cmd = new WrapTextCommand("[", "]");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testWrapLinesTextCommand() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("[", "]");
        assertEquals("[Hello]", cmd.execute("Hello"));
        assertEquals("[line1]\n[line2]", cmd.execute("line1\nline2"));
        assertEquals("[]\n[]", cmd.execute("\n"));
        assertEquals("[]", cmd.execute(""));
    }

    @Test
    void testWrapLinesTextCommandNullInput() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("[", "]");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testWrapSelectionTextCommand() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<", ">", "word");
        assertEquals("Hello <word> and <word>!", cmd.execute("Hello word and word!"));
        assertEquals("no match", cmd.execute("no match"));
        
        WrapSelectionTextCommand emptyCmd = new WrapSelectionTextCommand("<", ">", "");
        assertEquals("test", emptyCmd.execute("test"));
    }

    @Test
    void testWrapSelectionTextCommandNullInput() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<", ">", "word");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testCapitalizeTextCommand() {
        CapitalizeTextCommand cmd = new CapitalizeTextCommand();
        assertEquals("Hello", cmd.execute("hello"));
        assertEquals("  Hello", cmd.execute("  hello"));
        assertEquals("", cmd.execute(""));
        assertEquals("   ", cmd.execute("   "));
        assertEquals("123", cmd.execute("123"));
    }

    @Test
    void testCapitalizeTextCommandNullInput() {
        CapitalizeTextCommand cmd = new CapitalizeTextCommand();
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testCapitalizeWordsTextCommand() {
        CapitalizeWordsTextCommand cmd = new CapitalizeWordsTextCommand();
        assertEquals("Hello World", cmd.execute("hello world"));
        assertEquals("Test  Multiple  Spaces", cmd.execute("test  multiple  spaces"));
        assertEquals("", cmd.execute(""));
        assertEquals("A", cmd.execute("a"));
    }

    @Test
    void testCapitalizeWordsTextCommandNullInput() {
        CapitalizeWordsTextCommand cmd = new CapitalizeWordsTextCommand();
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testCapitalizeSelectionTextCommand() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("word");
        assertEquals("Hello Word and Word!", cmd.execute("Hello word and word!"));
        
        CapitalizeSelectionTextCommand emptyCmd = new CapitalizeSelectionTextCommand("");
        assertEquals("test", emptyCmd.execute("test"));
    }

    @Test
    void testCapitalizeSelectionTextCommandNullInput() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("word");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testScript() {
        List<TextCommand> commands = Arrays.asList(
            new ReplaceTextCommand("world", "Java"),
            new WrapTextCommand("[", "]"),
            new CapitalizeTextCommand()
        );
        Script script = new Script(commands);
        assertEquals("[hello Java]", script.execute("hello world"));
    }

    @Test
    void testScriptNullInput() {
        Script script = new Script(Arrays.asList(new CapitalizeTextCommand()));
        assertThrows(IllegalArgumentException.class, () -> script.execute(null));
    }

    @Test
    void testConstructorNullValidation() {
        assertThrows(NullPointerException.class, () -> new ReplaceTextCommand(null, "b"));
        assertThrows(NullPointerException.class, () -> new ReplaceTextCommand("a", null));
        assertThrows(NullPointerException.class, () -> new WrapTextCommand(null, "b"));
        assertThrows(NullPointerException.class, () -> new WrapTextCommand("a", null));
        assertThrows(NullPointerException.class, () -> new WrapSelectionTextCommand(null, "b", "c"));
        assertThrows(NullPointerException.class, () -> new WrapSelectionTextCommand("a", null, "c"));
        assertThrows(NullPointerException.class, () -> new WrapSelectionTextCommand("a", "b", null));
        assertThrows(NullPointerException.class, () -> new CapitalizeSelectionTextCommand(null));
        assertThrows(NullPointerException.class, () -> new Script(null));
    }
}
