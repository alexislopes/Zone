package zone.com.br.src.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import zone.com.br.src.R;
import zone.com.br.src.model.Usuario;
import zone.com.br.src.servico.UsuarioServicoCli;

public class PrincipalActivity extends AppCompatActivity {

    private static final String TAG = "PrincipalActivity ";

    EditText id;
    TextView resposta;
    Button btnBuscarUser;

    Button usuarios, login;

    List<Usuario> listausuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        usuarios = findViewById(R.id.imgusuarios);
        login = findViewById(R.id.button2);


        listausuarios = new UsuarioServicoCli().achaTodosUsuarios();




        usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent muda = new Intent(getApplicationContext(), Usuarios.class);
                startActivity(muda);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent muda = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(muda);
            }
        });

    }
}
