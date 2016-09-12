package br.edu.iff.pooa20161.contatossugar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20161.contatossugar.R;
import br.edu.iff.pooa20161.contatossugar.adapter.ContatoAdapter;
import br.edu.iff.pooa20161.contatossugar.models.Contato;

public class ContatoLVActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_lv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContatoLVActivity.this,ContatoActivity.class);
                intent.putExtra("id",0);
                intent.putExtra("nome","");
                intent.putExtra("email","");
                intent.putExtra("telefone","");

                startActivity(intent);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Contato> contatos  = (ArrayList) Contato.listAll(Contato.class);

        ListView lista = (ListView) findViewById(R.id.lvContatos);
        ArrayAdapter adapter = new ContatoAdapter(this,contatos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ContatoLVActivity.this,ContatoActivity.class);

                intent.putExtra("id",contatos.get(i).getId().intValue());
                intent.putExtra("nome",contatos.get(i).getNome());
                intent.putExtra("email",contatos.get(i).getEmail());
                intent.putExtra("telefone",contatos.get(i).getTelefone());

                startActivity(intent);

            }
        });


    }

}
