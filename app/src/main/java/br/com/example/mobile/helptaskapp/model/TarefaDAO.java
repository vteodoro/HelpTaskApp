package br.com.example.mobile.helptaskapp.model;

import android.database.sqlite.SQLiteDatabase;

import br.com.example.mobile.helptaskapp.Main;

public class TarefaDAO {

    public static TarefaDAO manager = new TarefaDAO();
    private TarefaDBHelper dbHelper;

    private TarefaDAO(){
        dbHelper = new TarefaDBHelper(Main.getContext());
    }

    public void salvar(Tarefa obj){
        SQLiteDatabase db =  dbHelper.getWritableDatabase();

    }

}
