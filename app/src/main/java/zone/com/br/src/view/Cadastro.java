package zone.com.br.src.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zone.com.br.src.R;
import zone.com.br.src.model.Usuario;

@SuppressLint("Registered")
public class Cadastro extends AppCompatActivity {

    EditText edtNome, edtUsuario, edtSenha, edtTelefone, edtEndereco;
    Button btnCadastrar;

    Handler handler = new Handler();
    ProgressDialog janela;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        conectaJavaXML();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                janela = new ProgressDialog(Cadastro.this);
                janela.setMessage("Cadastrando usuário...");
                janela.show();
            }
        });
    }

    public void conectaJavaXML(){
        edtNome = findViewById(R.id.edtNome);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEndereco = findViewById(R.id.edtEndereco);

        btnCadastrar = findViewById(R.id.btnCadastrar);
    }


}
