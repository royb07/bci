import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final Validator validator;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, Validator validator) {
        this.usuarioRepository = usuarioRepository;
        this.validator = validator;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        LocalDateTime now = LocalDateTime.now();
        usuario.setCreated(now);
        usuario.setLastLogin(now);
        validateUsuario(usuario);
        usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Long id, Usuario usuario) {
        LocalDateTime lastLogin = LocalDateTime.now();
        usuario.setId(id);
        usuario.setLastLogin(lastLogin);
        validateUsuario(usuario);
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    private void validateUsuario(Usuario usuario) {
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        if (!violations.isEmpty()) {
            List<ErrorDTO> errorMessages = violations.stream()
                    .map(violation -> new ErrorDTO(violation.getPropertyPath().toString(), violation.getMessage()))
                    .collect(Collectors.toList());
            throw new UsuarioValidationException(errorMessages);
        }
}
