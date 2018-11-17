package zone.com.br.src.controler;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import zone.com.br.src.model.Usuario;

public interface UsuarioDAO {
    boolean insereUsuario(String usuarioJson) throws IOException, XmlPullParserException;
    String achaUsuarioPorId(String usuarioJson) throws IOException, XmlPullParserException;
    String achaUsuarioPorNome(String usuarioJson) throws IOException, XmlPullParserException;
    String achaUsuarioPorUsuario(String usuarioJson) throws IOException, XmlPullParserException;
    String achaUsuarioPorEndereco(String usuarioJson) throws IOException, XmlPullParserException;
    List<Usuario> achaTodosUsuarios() throws IOException, XmlPullParserException;
    boolean atualizaUsuario(String usuarioJson) throws IOException, XmlPullParserException;
    boolean deletaUsuario(String usuarioJson) throws IOException, XmlPullParserException;
    boolean verificaUsuario(String usuarioJson) throws IOException, XmlPullParserException;
}
