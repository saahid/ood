package ood.design.splitwise;

public class IllegalSplitException extends RuntimeException {
    public IllegalSplitException(String message) {
        super(message);
    }

    public IllegalSplitException(String message, Throwable cause) {
        super(message, cause);
    }
}
