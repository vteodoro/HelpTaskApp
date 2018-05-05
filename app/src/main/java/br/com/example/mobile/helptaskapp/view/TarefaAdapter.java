package br.com.example.mobile.helptaskapp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.example.mobile.helptaskapp.R;
import br.com.example.mobile.helptaskapp.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter{

    private List<Tarefa> tarefas;
    private Context context;

    public TarefaAdapter(List<Tarefa> tarefas, Context context){
        this.tarefas = tarefas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.lista_tarefas_item, parent, false);
        TarefaViewHolder holder = new TarefaViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TarefaViewHolder viewHolder = (TarefaViewHolder) holder;

        Tarefa tarefa = tarefas.get(position);
        ((TarefaViewHolder)holder).preencher(tarefa);
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }
}