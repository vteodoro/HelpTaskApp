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

public class TarefaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public final TextView titulo;
    public final TextView artista;
    private Long tarefaId;
    public final TarefaAdapter adapter;

    public TarefaViewHolder(final View view, final TarefaAdapter adapter){
        super(view);
        this.adapter = adapter;

        view.setOnClickListener(this);
        view.setOnClickListener(this);

        titulo = view.findViewById(R.id.tvTitulo);
        artista = view.findViewById(R.id.tvArtista);
    }

    public void preencher(Musica musica){
        musicaId = musica.getId();
        titulo.setText(musica.getTitulo());
        artista.setText(musica.getArtista());
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), musicaId.toString(), Toast.LENGTH_SHORT).show();
        Log.d("Musica selecionada", musicaId.toString());
    }

    @Override
    public boolean onLongClick(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.musica_options, popupMenu.getMenu());

        final Activity context = (Activity)view.getContext();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                switch(item.getItemId()){

                    case R.id.menuMusEditar:
                        break;

                    case R.id.menuMusDeletar:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
        return false;

    }
}
