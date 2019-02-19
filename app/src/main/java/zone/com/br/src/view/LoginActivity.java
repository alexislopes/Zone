package zone.com.br.src.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Handler;
import android.widget.Toast;

import java.util.List;

import zone.com.br.src.R;
import zone.com.br.src.model.Usuario;
import zone.com.br.src.servico.UsuarioServicoCli;

public class LoginActivity extends AppCompatActivity {

    private List<String> usernames;

    EditText edtUsuario, edtSenha;
    Button btnEntrar, btnCadastrar;

    Handler handler = new Handler();
    ProgressDialog janela;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        conectaJavaXML();

        usernames = new UsuarioServicoCli().achaTodosUsernames();

        final String username = edtUsuario.getText().toString();
        final String senha = edtSenha.getText().toString();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                janela = new ProgressDialog(LoginActivity.this);
                janela.setMessage("Verificando dados...");
                janela.show();

                if(new UsuarioServicoCli().login(username, senha)){
                    Toast.makeText(getApplicationContext(), "Logado!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mudaTela = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(mudaTela);
            }
        });
    }

    public void conectaJavaXML(){
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
    }

}
