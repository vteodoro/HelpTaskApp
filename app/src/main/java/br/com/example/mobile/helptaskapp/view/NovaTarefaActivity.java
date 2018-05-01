package br.com.example.mobile.helptaskapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.example.mobile.helptaskapp.R;

public class NovaTarefaActivity extends AppCompatActivity{
    private EditText titulo;
    private EditText data;
    private EditText hora;
    private CheckBox urgente;
    private CheckBox importante;
    private EditText detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_tarefa);

        titulo = findViewById(R.id.etTitulo);
        data = findViewById(R.id.etData);
        hora = findViewById(R.id.etHora);
        urgente = findViewById(R.id.ckUrgente);
        importante = findViewById(R.id.ckImportante);
        detalhes = findViewById(R.id.etDetalhes);
    }
}
