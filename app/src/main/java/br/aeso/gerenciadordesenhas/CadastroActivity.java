package br.aeso.gerenciadordesenhas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.AccessibleObject;

import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.dao.SenhaDAO;
import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain.Login;

/**
 * Created by giulio on 14/05/16.
 */
public class CadastroActivity extends Activity{
    private EditText usuario, senha;
    private SenhaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        dao = new SenhaDAO(this);

        usuario = (EditText) findViewById(R.id.usuarioCadastro);
        senha = (EditText) findViewById(R.id.senhaCadastro);
    }

    public void cadastrarLoginOnClick(View view){
        Login login = new Login();

        login.setUsuario(usuario.getText().toString());
        login.setSenha(Integer.parseInt(senha.getText().toString()));

        long resultado = dao.cadastrarLogin(login);

        if(resultado != -1){
            Toast.makeText(this, R.string.login_sucesso, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SenhaActivity.class));
        }
    }
}
