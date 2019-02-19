package zone.com.br.src.servico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zone.com.br.src.model.Usuario;

public interface UsuarioService {

    @GET("usuario/achaUsuarioPorId?id={id}")
    Call<Usuario> buscarUsuarioPorId(@Path(value = "id") String id);

    @GET(value = "usuario/achaTodosUsuarios")
    Call<List<Usuario>> achaTodosUsuarios();

    @GET(value = "usuario/achaTodosUsernames")
    Call<List<String>> achaTodosUsernames();

    @GET(value = "usuario/login?username={username}&senha={senha}")
    Call<Boolean> login(@Path(value = "username") String id, @Path(value = "senha") String senha);


}
