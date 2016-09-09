package br.edu.iff.pooa20161.contatossugar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20161.contatossugar.R;
import br.edu.iff.pooa20161.contatossugar.models.Contato;
import br.edu.iff.pooa20161.contatossugar.adapter.ContatoAdapter;

public class ContatoLVMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_lvmain);

        ArrayList<Contato> contatos = (ArrayList) Contato.listAll(Contato.class);

        ListView lista = (ListView) findViewById(R.id.lvContatos);
        ArrayAdapter adapter = new ContatoAdapter(this,contatos);
        lista.setAdapter(adapter);

    }
}
