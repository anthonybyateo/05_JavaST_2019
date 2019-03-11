package by.training.taskthread.exception;

public class NotIntegerArgumentException extends Exception{
    public NotIntegerArgumentException() {
    }

    public NotIntegerArgumentException(String message) {
        super(message);
    }

    public NotIntegerArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotIntegerArgumentException(Throwable cause) {
        super(cause);
    }
}
