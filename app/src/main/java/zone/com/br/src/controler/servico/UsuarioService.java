package zone.com.br.src.controler.servico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zone.com.br.src.model.Usuario;

public interface UsuarioService {

    @GET("usuario/achaUsuarioPorId/{id}")
    Call<Usuario> buscarUsuarioPorId(@Path(value = "id") String id);

    @GET(value = "usuario/achaTodosUsuarios")
    Call<List<Usuario>> achaTodosUsuarios();
}
