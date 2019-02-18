package zone.com.br.src.servico;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import zone.com.br.src.configs.RetrofitConfig;
import zone.com.br.src.model.Usuario;

public class UsuarioServicoCli {

    private RetrofitConfig retrofitConfig = new RetrofitConfig();

    private Retrofit retrofit = retrofitConfig.getRetrofit();

    private UsuarioService usuarioService = retrofit.create(UsuarioService.class);

    private List<Usuario> usuarios;

    private Usuario usuario;

    public List<Usuario> achaTodosUsuarios(){
        //acha todos usuarios
        Call<List<Usuario>> call = usuarioService.achaTodosUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {

            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                usuarios = response.body();

                if(usuarios != null && !usuarios.isEmpty()) {
                    for (Usuario u : usuarios) {
                        Log.d("USUÁRIO: ", u.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.d("ERROOOOOO: ", t.getMessage());
            }
        });

        return usuarios;
    }

    public Usuario achaUsuarioPorId(String id){
        //acha usuario por id
        Call<Usuario> callUsuario = usuarioService.buscarUsuarioPorId(id);

        callUsuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                usuario = response.body();
                Log.d("USUÁRIO: ", usuario.toString());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.d("ERROOOOOO: ", t.getMessage());
            }
        });

        return usuario;
    }
}
