import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
public class UsuarioServiceTests {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void crearUsuario() {
        // ...

        Usuario usuario = new Usuario();
        usuario.setName("John Doe");
        usuario.setEmail("john@example.com");
        usuario.setPassword("a2asfGfdfdf4");
        usuario.setPhones(phones);

        usuarioService.crearUsuario(usuario);

        Long id = usuario.getId();
        Assertions.assertNotNull(id);

        Usuario usuarioGuardado = usuarioRepository.findById(id).orElse(null);
        Assertions.assertNotNull(usuarioGuardado);
        Assertions.assertEquals("John Doe", usuarioGuardado.getName());
        Assertions.assertEquals("john@example.com", usuarioGuardado.getEmail());
        Assertions.assertEquals("a2asfGfdfdf4", usuarioGuardado.getPassword());
        Assertions.assertEquals(phones, usuarioGuardado.getPhones());
        Assertions.assertNotNull(usuarioGuardado.getCreated());
        Assertions.assertNotNull(usuarioGuardado.getLastLogin());
        // ...
    }

    @Test
    public void actualizarUsuario() {
        // ...

        Usuario usuario = new Usuario();
        usuario.setName("John Doe");
        usuario.setEmail("john@example.com");
        usuario.setPassword("a2asfGfdfdf4");
        usuario.setPhones(phones);

        usuarioService.crearUsuario(usuario);

        Long id = usuario.getId();
        Assertions.assertNotNull(id);

        // ...

    }
}