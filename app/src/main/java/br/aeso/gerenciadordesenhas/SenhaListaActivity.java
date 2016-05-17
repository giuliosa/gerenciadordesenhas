package br.aeso.gerenciadordesenhas;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.dao.SenhaDAO;

/**
 * Created by giulio on 14/05/16.
 */
public class SenhaListaActivity
        extends ListActivity
        implements AdapterView.OnItemClickListener {

    private Integer id;
    private SenhaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listarSenhas()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);

        id = getIntent().getExtras().getInt(DatabaseHelper.Login._ID);
        dao = new SenhaDAO(this);
    }

    private List<String> listarSenhas(){
        return Arrays.asList("Facebook", "Twitter", "Google", "Github");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        String mensagem = "Senha selecionada: " + textView.getText();

        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }
}
