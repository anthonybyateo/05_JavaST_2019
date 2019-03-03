package by.training.taskobject.exception;

public class NotDoubleArgumentException extends Exception {
    public NotDoubleArgumentException() {
    }

    public NotDoubleArgumentException(final String message) {
        super(message);
    }

    public NotDoubleArgumentException(final String message,
                                      final Throwable cause) {
        super(message, cause);
    }

    public NotDoubleArgumentException(final Throwable cause) {
        super(cause);
    }
}
