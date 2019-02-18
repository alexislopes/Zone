package zone.com.br.src.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import zone.com.br.src.R;
import zone.com.br.src.adapter.UsuarioAdapter;
import zone.com.br.src.model.Usuario;

public class Usuarios extends AppCompatActivity {
    private RecyclerView recyclerUsuario;
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listausuarios);

        recyclerUsuario = findViewById(R.id.recyclerUsuarios);

        //define layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerUsuario.setLayoutManager(layoutManager);

        //pega todos usuarios
        /*RetrofitConfig retrofitConfig = new RetrofitConfig();

        Retrofit retrofit = retrofitConfig.getRetrofit();

        UsuarioService usuarioService = retrofit.create(UsuarioService.class);

        Call<List<Usuario>> call = usuarioService.achaTodosUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                usuarios = response.body();

                for (Usuario u : usuarios) {
                    Log.d("USUÁRIO: ", u.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.d("ERROOOOOO: ", t.getMessage());
            }
        });*/

        //enche();

        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
        recyclerUsuario.setAdapter(adapter);
    }

    public void enche() {
        Usuario usuario;
        usuario = new Usuario("Gabriel", "Fallen");
        usuarios.add(usuario);

        usuario = new Usuario("Marcelo", "Coldzera");
        usuarios.add(usuario);

        usuario = new Usuario("Fernando", "Fer");
        usuarios.add(usuario);

        usuario = new Usuario("Epitácio", "Taco");
        usuarios.add(usuario);

        usuario = new Usuario("João", "Felps");
        usuarios.add(usuario);
    }
}
