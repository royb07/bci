

public class UsuarioValidationException extends RuntimeException {
    private final List<ErrorDTO> errorMessages;

    public UsuarioValidationException(List<ErrorDTO> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<ErrorDTO> getErrorMessages() {
        return errorMessages;
    }
}
