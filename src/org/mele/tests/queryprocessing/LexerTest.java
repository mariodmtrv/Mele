package org.mele.tests.queryprocessing;

import org.junit.*;
import org.mele.backend.queryprocessing.Lexer;
import org.mele.backend.queryprocessing.Token;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by mariodimitrov on 12/17/14.
 */

public class LexerTest {
    @Test
    public void testTokenization() {
        String query = "x=abs(x)";
        List<Token> tokens = Lexer.tokenize(query);
        assertEquals(tokens.size(), 6);
    }

    @Test
    public void testLongerInput() {
        String query = "alpha=180+    sin  (   beta  /  (   2*(  180 \n - alpha ))  )";
        List<Token> tokens = Lexer.tokenize(query);
        assertEquals(tokens.size(), 18);
    }

    @Test
    public void testEmpty() {

        String query = "";
        List<Token> tokens = Lexer.tokenize(query);

        assertEquals(tokens.size(), 0);
    }

    @Test
    public void testSign() {
        String query = "x-=y";
        List<Token> tokens = Lexer.tokenize(query);

        assertEquals(tokens.size(), 4);
    }

    @Test
    public void testNewlines() {
        String query = "\n    \n \r";
        List<Token> tokens = Lexer.tokenize(query);
        assertEquals(tokens.size(), 0);
    }
}
