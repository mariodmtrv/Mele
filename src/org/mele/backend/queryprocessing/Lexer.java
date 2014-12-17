package org.mele.backend.queryprocessing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mariodimitrov on 12/17/14.
 */
public class Lexer {
    static Pattern tokenPatterns;

    static {
        StringBuilder tokenPatternsBuffer = new StringBuilder();
        for (TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

    }

    public static ArrayList<Token> tokenize(String input) {

        ArrayList<Token> tokens = new ArrayList<Token>();


        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            String match = matcher.group(TokenType.NUMBER.name());
            if (match != null) {
                tokens.add(new Token(TokenType.NUMBER, match));
                continue;
            } else {
                match = matcher.group(TokenType.STRING.name());
                if (match != null) {
                    tokens.add(new Token(TokenType.STRING, match));
                } else {
                    match = matcher.group(TokenType.BINARYOP.name());
                    if (match != null) {
                        tokens.add(new Token(TokenType.BINARYOP, match));
                        continue;
                    } else {
                        match = matcher.group(TokenType.BRACKET.name());
                        if (match != null) {
                            tokens.add(new Token(TokenType.BRACKET, match));
                        } else if (matcher.group(TokenType.WHITESPACE.name()) != null) {
                            continue;
                        }
                    }
                }
            }
        }

        return tokens;
    }
}
