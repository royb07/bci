

public class UsuarioValidationException extends RuntimeException {
    private final List<String> errorMessages;

    public UsuarioValidationException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
