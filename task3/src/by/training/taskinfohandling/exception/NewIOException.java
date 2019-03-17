package by.training.taskinfohandling.exception;

public class NewIOException extends Exception {
    public NewIOException() {
    }

    public NewIOException(String message) {
        super(message);
    }

    public NewIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewIOException(Throwable cause) {
        super(cause);
    }
}
