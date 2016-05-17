package br.aeso.gerenciadordesenhas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.dao.SenhaDAO;
import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain.Senha;

/**
 * Created by giulio on 14/05/16.
 */
public class SenhaActivity extends Activity{
    private Spinner apps;
    private Integer id;
    private EditText login, password;
    private SenhaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senha);

        dao = new SenhaDAO(this);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.apps, android.R.layout.simple_spinner_item
        );

        id = getIntent().getExtras().getInt(DatabaseHelper.Login._ID);

        apps = (Spinner) findViewById(R.id.app);
        apps.setAdapter(arrayAdapter);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

    }

    public void cadastrarSenhaOnclick(View view){
        Senha senha = new Senha();

        senha.setApp(apps.getSelectedItem().toString());
        senha.setLogin(login.getText().toString());
        senha.setPassword(password.getText().toString());
        senha.setLoginId(id);

        long resultado = dao.cadastrarSenha(senha);

        if(resultado != -1){
            Toast.makeText(this, R.string.senha_sucesso, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SenhaListaActivity.class);
            intent.putExtra(DatabaseHelper.Login._ID, senha.getLoginId());
            startActivity(intent);
        }
    }
}
