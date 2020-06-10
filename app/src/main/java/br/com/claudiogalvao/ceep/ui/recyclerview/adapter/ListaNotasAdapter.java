package br.com.claudiogalvao.ceep.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.claudiogalvao.ceep.R;
import br.com.claudiogalvao.ceep.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter {

    private List<Nota> notas;
    private Context context;

    public ListaNotasAdapter(Context context, List<Nota> notas) {
        this.context = context;
        this.notas = notas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
        * Em analogia com o BaseAdapter do ListView, ele seria o responsável por criar as Views
        * a partir de um layout. O resultado disso é o que chamamos de ViewHolder.
        * Esse método é chamdo um única vez para criar todos os ViewHolder, que serão estão
        * reaproveitados conforte acontece o Scroll no app. São criados 7 views
        * */
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        /*
        * Após a criação do ViewHolder no onCreateViewHolder, o onBindViewHolder é chamado.
        * A ideia do onBindViewHolder é pegar essas ViewHolder que foram criadas e fazer o processo de
        * Bind, ou seja, pegar as informações do objeto e colocar essas informações dentro das
        * ViewHolders a partir da posição, ou seja, vincular os dados do objeto ao ViewHolder.
        * Esse é o método que chamado no evento de Scroll, pois o onCreateViewHolder já criou o
        * todos os ViewHolder.
        * Ao passar dos 7 primeiros, a primeira view que já não está aparecendo na tela, é reciclada,
        * passando a não existir mais as informações da primeira view, agora ela é reproveitada
        * para inserir os dados da última view, a 8a no caso.
        * */
        Nota nota = notas.get(position);
        TextView titulo = holder.itemView.findViewById(R.id.item_nota_titulo);
        titulo.setText(nota.getTitulo());

        TextView descricao = holder.itemView.findViewById(R.id.item_nota_descricao);
        descricao.setText(nota.getDescricao());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {
        /*
        * É necessário criar essa classe para que possamos passar para ela a nossa view
        * a partir do nosso layout personalizado, e ele irá retornar todas as ViewHolder criadas,
        * ou seja, os nossos containers.
        * */

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
