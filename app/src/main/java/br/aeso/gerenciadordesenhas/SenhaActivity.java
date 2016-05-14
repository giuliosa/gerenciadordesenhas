package br.aeso.gerenciadordesenhas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by giulio on 14/05/16.
 */
public class SenhaActivity extends Activity{
    private Spinner apps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senha);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.apps, R.layout.support_simple_spinner_dropdown_item
        );


        apps = (Spinner) findViewById(R.id.app);
        apps.setAdapter(arrayAdapter);

    }
}
