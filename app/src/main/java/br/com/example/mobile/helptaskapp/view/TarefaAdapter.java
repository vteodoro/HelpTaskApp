package br.com.example.mobile.helptaskapp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.example.mobile.helptaskapp.R;
import br.com.example.mobile.helptaskapp.model.Tarefa;
import br.com.example.mobile.helptaskapp.model.TarefaDAO;

public class TarefaAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private TarefaDAO dao = TarefaDAO.manager;
    private Map<Integer, Long> mapa;
    private List<Tarefa> tarefas;
    private EditarTarefas delegate;
    private Context context;

    public TarefaAdapter(EditarTarefas edT){
        criarMapa();
        delegate = edT;
    }

//    public TarefaAdapter(List<Tarefa> tarefas, Context context){
//        this.tarefas = tarefas;
//        this.context = context;
//    }

    @Override
    public void notifyDataSetChanged(){
        criarMapa();
        super.notifyDataSetChanged();
    }

    private void criarMapa(){
        mapa = new HashMap<>();
        List<Tarefa> lista = dao.getLista();

        for(int linha = 0; linha < lista.size(); linha ++){
            Tarefa tarefa = lista.get(linha);
            mapa.put(linha, tarefa.getId());
        }

    }

    @Override
    public int getCount(){
        return mapa.size();
    }

    @Override
    public Object getItem(int id){
        return dao.getTarefa((long)id);
    }

    @Override
    public long getItemId(int linha){
        return mapa.get(linha);
    }

//    @Override
//    public int getItemCount() {
//        return tarefas.size();
//    }

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


}