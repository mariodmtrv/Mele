package org.mele.backend.exceptions;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class WrongNumberOfArgumentsException extends Exception {
    public WrongNumberOfArgumentsException(String message) {
        super(message);
    }

    public WrongNumberOfArgumentsException() {
        super("Value properties count does not match the resource contract");
    }
}
