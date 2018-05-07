package br.com.example.mobile.helptaskapp.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import br.com.example.mobile.helptaskapp.R;
import br.com.example.mobile.helptaskapp.model.Tarefa;

public class TarefaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public final TextView titulo;
    public final TextView data;
    private Long tarefaId;
    public final TarefaAdapter adapter;

    public TarefaViewHolder(final View view, final TarefaAdapter adapter){
        super(view);
        this.adapter = adapter;

        view.setOnClickListener(this);
        view.setOnClickListener(this);

        titulo = view.findViewById(R.id.tvTitulo);
        data = view.findViewById(R.id.tvData);
    }

    public void preencher(Tarefa tarefa){
        tarefaId = tarefa.getId();
        titulo.setText(tarefa.getTitulo());
        data.setText(tarefa.getData());
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), tarefaId.toString(), Toast.LENGTH_SHORT).show();
        Log.d("Tarefa selecionada", tarefaId.toString());
    }

    @Override
    public boolean onLongClick(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_tarefas, popupMenu.getMenu());

        final Activity context = (Activity)view.getContext();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                switch(item.getItemId()){

                    case R.id.newTask:
                        break;

                    case R.id.list:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
        return false;

    }
}
