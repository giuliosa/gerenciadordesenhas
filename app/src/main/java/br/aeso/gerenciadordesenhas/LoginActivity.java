package br.aeso.gerenciadordesenhas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.dao.SenhaDAO;
import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain.Login;

/**
 * Created by giulio on 10/12/15.
 */
public class LoginActivity extends Activity{
    private EditText login;
    private EditText senha;
    private SenhaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        dao = new SenhaDAO(this);

        login = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);
    }

    //Metodo para entrar no app
    public void entrarOnClick(View view){
        String usuarioInformado = login.getText().toString();
        String senhaInformada = senha.getText().toString();

        Login login = dao.procurarLogin(usuarioInformado, Integer.parseInt(senhaInformada));

        if (login != null){
            /*Implementar a Activity que será chamada
             caso o login e senha estejam corretos*/

            Intent intent = new Intent(this, SenhaActivity.class);
            intent.putExtra(DatabaseHelper.Login._ID,login.getId());
            startActivity(intent);
            Toast toast = Toast.makeText(this, R.string.bem_vindo, Toast.LENGTH_SHORT);

            toast.show();
        } else {
            String erro = getString(R.string.erro_validacao);
            Toast toast = Toast.makeText(this, erro, Toast.LENGTH_SHORT);

            toast.show();
        }

        /*if ("leitor".equals(usuarioInformado) && "123".equals(senhaInformada)){
            *//*Implementar a Activity que será chamada
             caso o login e senha estejam corretos*//*
            Intent intent = new Intent(this, SenhaActivity.class);
            startActivity(intent);
            String teste = "Seja bem-vindo!";
            Toast toast = Toast.makeText(this, teste, Toast.LENGTH_SHORT);

            toast.show();
        } else {
            String erro = getString(R.string.erro_validacao);
            Toast toast = Toast.makeText(this, erro, Toast.LENGTH_SHORT);

            toast.show();
        }*/
    }

    public void cadastrarOnClick(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
