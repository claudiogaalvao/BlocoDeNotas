package br.com.claudiogalvao.ceep.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.claudiogalvao.ceep.R;
import br.com.claudiogalvao.ceep.dao.NotaDAO;
import br.com.claudiogalvao.ceep.model.Nota;
import br.com.claudiogalvao.ceep.ui.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listView);

        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeira nota", "Primeira descrição"));
        List<Nota> todasNotas = dao.todos();

        ListaNotasAdapter adapter = new ListaNotasAdapter(this, todasNotas);
        listaNotas.setAdapter(adapter);

    }
}
