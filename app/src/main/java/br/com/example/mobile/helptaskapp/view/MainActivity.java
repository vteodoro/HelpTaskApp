package br.com.example.mobile.helptaskapp.view;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.List;

import br.com.example.mobile.helptaskapp.R;
import br.com.example.mobile.helptaskapp.model.Tarefa;
//import br.com.example.mobile.helptaskapp.model.TarefaDAO;
//import br.com.example.mobile.helptaskapp.model.TarefaDBHelper;

public class MainActivity extends AppCompatActivity {

    //private TarefaDAO dao = TarefaDAO.manager;
   // private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List<Tarefa> tarefas = dao.getLista();


        //Context ctx = null;
        //SQLiteDatabase db = ctx.openOrCreateDatabase(null, Context.MODE_PRIVATE,null);

//        recyclerView = findViewById(R.id.rvTarefas);
//
//        recyclerView.setAdapter(new TarefaAdapter(tarefas, this));
//
//        RecyclerView.LayoutManager layout = new GridLayoutManager(this, 2);
//
//        recyclerView.setLayoutManager(layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tarefas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.newTask:
                startActivity(new Intent(this, NovaTarefaActivity.class));
                return true;

            case R.id.list:
                startActivity(new Intent(this,ListarTarefaActivity.class ));
        }
        return onOptionsItemSelected(item);
    }


}
