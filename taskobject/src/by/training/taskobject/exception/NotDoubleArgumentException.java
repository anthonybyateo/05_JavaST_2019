package by.training.taskobject.exception;

public class NotDoubleArgumentException extends Exception {
    public NotDoubleArgumentException() {
    }

    public NotDoubleArgumentException(String message) {
        super(message);
    }

    public NotDoubleArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotDoubleArgumentException(Throwable cause) {
        super(cause);
    }
}
