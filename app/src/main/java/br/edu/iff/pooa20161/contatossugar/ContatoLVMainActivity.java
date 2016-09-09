package br.edu.iff.pooa20161.contatossugar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContatoLVMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_lvmain);

        ListView lista = (ListView) findViewById(R.id.lvContatos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.contatos,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

    }
}
