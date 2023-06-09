import java.util.List;

public interface UsuarioService {
    List<Usuario> obtenerUsuarios();
    void crearUsuario(Usuario usuario);
    void actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
}
