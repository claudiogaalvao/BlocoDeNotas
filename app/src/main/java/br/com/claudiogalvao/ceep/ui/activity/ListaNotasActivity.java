package br.com.claudiogalvao.ceep.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.claudiogalvao.ceep.R;
import br.com.claudiogalvao.ceep.dao.NotaDAO;
import br.com.claudiogalvao.ceep.model.Nota;
import br.com.claudiogalvao.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for(int i = 0; i <= 100; i++) {
            dao.insere(new Nota("Nota" + i, "Descrição" + i));
        }
        List<Nota> todasNotas = dao.todos();

        ListaNotasAdapter adapter = new ListaNotasAdapter(this, todasNotas);
        listaNotas.setAdapter(adapter);
        /*
        * Por conta da característica flexível do RecyclerView, é necessário indicarmos para ele
        * como queremos que seja apresentado nossos containers. Para isso, usamos um LayoutManager,
        * nesse caso, podemos usar um LayoutManager pré-definido.
        * */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);


    }
}
