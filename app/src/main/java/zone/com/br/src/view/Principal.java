package zone.com.br.src.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import zone.com.br.src.R;
import zone.com.br.src.configs.RetrofitConfig;
import zone.com.br.src.controler.servico.UsuarioService;
import zone.com.br.src.model.Usuario;

public class Principal extends AppCompatActivity {

    private static final String TAG = "Principal ";

    EditText id;
    TextView resposta;
    Button btnBuscarUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pegausuario);

        RetrofitConfig retrofitConfig = new RetrofitConfig();

        Retrofit retrofit = retrofitConfig.getRetrofit();

        UsuarioService usuarioService = retrofit.create(UsuarioService.class);

        Call<List<Usuario>> call = usuarioService.achaTodosUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                List<Usuario> usuarios = response.body();

                for (Usuario u : usuarios) {
                    Log.d("USUÁRIO: ", u.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.d("ERROOOOOO: ", t.getMessage());
            }
        });

        Call<Usuario> callUsuario = usuarioService.buscarUsuarioPorId("U09");

        callUsuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario user = response.body();
                Log.d("USUÁRIO: ", user.toString());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.d("ERROOOOOO: ", t.getMessage());
            }
        });

    }
}
