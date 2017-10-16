package ru.edhunter.independent_seatwork.inner_classes.runtime_Exceptions;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException () {
    }

    public InvalidOperationException (String message) {
        super (message);
    }

    public InvalidOperationException (Throwable cause) {
        super (cause);
    }

    public InvalidOperationException (String message, Throwable cause) {
        super (message, cause);
    }

}
