package br.edu.iff.pooa20161.contatossugar.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iff.pooa20161.contatossugar.R;
import br.edu.iff.pooa20161.contatossugar.models.Contato;
import br.edu.iff.pooa20161.contatossugar.adapter.ContatoAdapter;

public class ContatoLVMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_lvmain);


    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Contato> contatos = (ArrayList) Contato.listAll(Contato.class);

        ListView lista = (ListView) findViewById(R.id.lvContatos);
        ArrayAdapter adapter = new ContatoAdapter(this,contatos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ContatoLVMainActivity.this,ContatoActivity.class);

                intent.putExtra("nome",contatos.get(i).getNome());
                intent.putExtra("email",contatos.get(i).getEmail());
                intent.putExtra("telefone",contatos.get(i).getTelefone());

                startActivity(intent);

            }
        });


    }

}
