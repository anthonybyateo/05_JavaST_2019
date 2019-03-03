package by.training.taskobject.exception;

public class IllegalAmountArgumentException extends Exception {
    public IllegalAmountArgumentException() {
    }

    public IllegalAmountArgumentException(final String message) {
        super(message);
    }

    public IllegalAmountArgumentException(final String message,
                                          final Throwable cause) {
        super(message, cause);
    }

    public IllegalAmountArgumentException(final Throwable cause) {
        super(cause);
    }
}
