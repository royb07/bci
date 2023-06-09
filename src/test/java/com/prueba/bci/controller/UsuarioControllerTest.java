import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerUsuarios_debeRetornarListaDeUsuarios() {
        // Arrange
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setName("Usuario 1");
        usuario1.setEmail("usuario1@example.com");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setName("Usuario 2");
        usuario2.setEmail("usuario2@example.com");

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        when(usuarioService.obtenerUsuarios()).thenReturn(usuarios);

        // Act
        List<Usuario> resultado = usuarioController.obtenerUsuarios();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Usuario 1", resultado.get(0).getName());
        assertEquals("usuario1@example.com", resultado.get(0).getEmail());
        assertEquals("Usuario 2", resultado.get(1).getName());
        assertEquals("usuario2@example.com", resultado.get(1).getEmail());

        verify(usuarioService, times(1)).obtenerUsuarios();
    }

    @Test
    public void crearUsuario_debeLlamarMetodoCrearUsuarioDelServicio() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setName("Usuario Nuevo");
        usuario.setEmail("nuevo@example.com");

        // Act
        usuarioController.crearUsuario(usuario);

        // Assert
        verify(usuarioService, times(1)).crearUsuario(usuario);
    }

    @Test
    public void actualizarUsuario_debeLlamarMetodoActualizarUsuarioDelServicio() {
        // Arrange
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setName("Usuario Actualizado");
        usuario.setEmail("actualizado@example.com");

        // Act
        usuarioController.actualizarUsuario(id, usuario);

        // Assert
        verify(usuarioService, times(1)).actualizarUsuario(id, usuario);
    }

    @Test
    public void eliminarUsuario_debeLlamarMetodoEliminarUsuarioDelServicio() {
        // Arrange
        Long id = 1L;

        // Act
        usuarioController.eliminarUsuario(id);

        // Assert
        verify(usuarioService, times(1)).eliminarUsuario(id);
    }
}
