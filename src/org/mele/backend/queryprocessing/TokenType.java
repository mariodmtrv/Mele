package org.mele.backend.queryprocessing;

/**
 * Created by mariodimitrov on 12/17/14.
 */
public enum TokenType {
    // Token types cannot have underscores
    NUMBER("-?[0-9]+"), BINARYOP("[*|/|+|=|-]"), BRACKET("[(|)|{|}]"), WHITESPACE("[ \t\f\r\n]+"), STRING("[\\w]+");

    public final String pattern;

    private TokenType(String pattern) {
        this.pattern = pattern;
    }
}
