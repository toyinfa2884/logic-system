package africa.semicolon.logisticSystem.exceptions;

import africa.semicolon.logisticSystem.exceptions.LogisticException;

public class SenderDoesNotExistException extends LogisticException {
    public SenderDoesNotExistException(String message) {
        super(message);
    }
}
