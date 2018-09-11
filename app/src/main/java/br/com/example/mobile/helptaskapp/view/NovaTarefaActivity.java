package br.com.example.mobile.helptaskapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.example.mobile.helptaskapp.R;
import br.com.example.mobile.helptaskapp.model.Tarefa;
import br.com.example.mobile.helptaskapp.model.TarefaDAO;

public class NovaTarefaActivity extends AppCompatActivity {
    private TarefaDAO dao = TarefaDAO.manager;
    private Tarefa tarefa;
    private EditText titulo;
    private EditText data;
    private EditText hora;
    private CheckBox urgente;
    private CheckBox importante;
    private EditText detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_tarefa);

        titulo = findViewById(R.id.etTitulo);
        data = findViewById(R.id.etData);
        hora = findViewById(R.id.etHora);
        urgente = findViewById(R.id.ckUrgente);
        importante = findViewById(R.id.ckImportante);
        detalhes = findViewById(R.id.etDetalhes);

        Intent intent = getIntent();
        if(intent != null){
            Bundle dados = intent.getExtras();
            if(dados != null){
                long id = dados.getLong("id");
                tarefa = dao.getTarefa(id);
                if(tarefa != null){
                    titulo.setText(tarefa.getTitulo());
                    data.setText(tarefa.getData());
                    hora.setText(tarefa.getHora());
                    urgente.setChecked(tarefa.isUrgente());
                    importante.setChecked(tarefa.isImportante());
                    detalhes.setText(tarefa.getDetalhes());
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_salvar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveTask:
                startActivity(new Intent(this, MainActivity.class));
                return true;
        }
        return onOptionsItemSelected(item);
    }
}