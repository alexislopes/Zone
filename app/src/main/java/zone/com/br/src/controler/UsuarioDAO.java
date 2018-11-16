package zone.com.br.src.controler;

import java.util.List;

import zone.com.br.src.model.Usuario;

public interface UsuarioDAO {
    boolean insereUsuario(String usuarioJson);
    String achaUsuarioPorId(String usuarioJson);
    String achaUsuarioPorNome(String usuarioJson);
    String achaUsuarioPorUsuario(String usuarioJson);
    String achaUsuarioPorEndereco(String usuarioJson);
    List<Usuario> achaTodosUsuarios();
    boolean atualizaUsuario(String usuarioJson);
    boolean deletaUsuario(String usuarioJson);
}
