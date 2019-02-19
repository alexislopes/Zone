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

    private List<String> usernames;

    private Usuario usuario;

    private Boolean logado;

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
                usuario = null;
                Log.d("ERROOOOOO: ", t.getMessage());
            }
        });

        return usuario;
    }

    public List<String> achaTodosUsernames(){
        Call<List<String>> callUsernames = usuarioService.achaTodosUsernames();

        callUsernames.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                usernames = response.body();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                usernames = null;
            }
        });

        return usernames;
    }

    public Boolean login(String username, String senha){
        Call<Boolean>  callLogin = usuarioService.login(username, senha);

        callLogin.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                logado = response.body();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });

        return logado;
    }
}
