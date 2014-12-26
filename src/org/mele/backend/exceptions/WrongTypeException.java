package org.mele.backend.exceptions;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class WrongTypeException extends Exception {
    public WrongTypeException() {
        super();
    }

    public WrongTypeException(String expectedType) {
        super("The value is not of type by resource contract. Expected type:" + expectedType);
    }

}
