package org.mele.backend.queryprocessing;

/**
 * Created by mariodimitrov on 12/17/14.
 */
public class Token {
    public TokenType type;
    public String data;

    public Token(TokenType type, String data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", type.name(), data);
    }
}
