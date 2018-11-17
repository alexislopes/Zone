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

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import zone.com.br.src.R;
import zone.com.br.src.controler.servico.ClienteWebServices;
import zone.com.br.src.model.Usuario;

public class Login extends AppCompatActivity implements Runnable{

    EditText edtUsuario, edtSenha;
    Button btnEntrar, btnCadastrar;

    Handler handler = new Handler();
    ProgressDialog janela;
    Thread tarefa;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        conectaJavaXML();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                janela = new ProgressDialog(Login.this);
                janela.setMessage("Verificando dados...");
                janela.show();

                tarefa = new Thread(Login.this);
                tarefa.start();
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mudaTela = new Intent(Login.this, Cadastro.class);
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

    @Override
    public void run() {
        ClienteWebServices clienteWebServices = new ClienteWebServices();
        usuario = new Usuario(edtUsuario.getText().toString(), edtSenha.getText().toString());

        final String usuarioJson = usuario.toJson();


        try {
            final boolean resposta = clienteWebServices.verificaUsuario(usuarioJson);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(resposta) {
                        Intent mudaTela = new Intent(Login.this, Principal.class);
                        mudaTela.putExtra("usuario", usuarioJson);
                        startActivity(mudaTela);
                    } else {
                        Toast.makeText(Login.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        } finally {
            janela.dismiss();
        }

    }
}
