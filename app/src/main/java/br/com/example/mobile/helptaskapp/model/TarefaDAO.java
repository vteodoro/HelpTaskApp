package br.com.example.mobile.helptaskapp.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.com.example.mobile.helptaskapp.Main;

public class TarefaDAO {

    public static TarefaDAO manager = new TarefaDAO();
    private TarefaDBHelper dbHelper;

    private TarefaDAO(){
        dbHelper = new TarefaDBHelper(Main.getContext());
    }

    public void salvar(Tarefa obj){
        SQLiteDatabase db =  dbHelper.getWritableDatabase();

        if(obj.getId() == null){
            String inserir = "insert into " + TarefaDBHelper.TABELA +
                    "(titulo, data, hora, urgente, importante, detalhes) values(?, ?, ?, ?, ?, ?)";
            db.execSQL(inserir, new Object[]{obj.getTitulo(), obj.getData(), obj.getHora(), obj.isUrgente(),
            obj.isImportante(), obj.getDetalhes()});
        }else{
            String update = "update " + TarefaDBHelper.TABELA + " set titulo = ?, data = ?, hora = ?, urgente = ?, " +
                    "importante = ?, detalhes = ? where _id = ?";
            db.execSQL(update, new Object[]{obj.getTitulo(), obj.getData(), obj.getHora(), obj.isUrgente(),
                    obj.isImportante(), obj.getDetalhes(), obj.getId()});
        }
        db.close();
    }

    public List<Tarefa> getLista(){
        List<Tarefa> tarefas = new LinkedList<>();
        String rawQuery = "select _id, titulo, data, hora, urgente, importante, detalhes from" +
                TarefaDBHelper.TABELA + " order by titulo";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(rawQuery, null);

        if(cursor.moveToFirst()){
            do{
                Tarefa tarefa = new Tarefa();
                tarefa.setId(cursor.getLong(0));
                tarefa.setTitulo(cursor.getString(1));
                tarefa.setData(cursor.getString(2));
                tarefa.setHora(cursor.getLong(3));
                tarefa.setUrgente(Boolean.parseBoolean(cursor.getString(4)));
                tarefa.setImportante(Boolean.parseBoolean(cursor.getString(5)));
                tarefa.setDetalhes(cursor.getString(6));
                tarefas.add(tarefa);

            }while(cursor.moveToNext());
        }
        return tarefas;
    }

    public Tarefa getTarefa(final Long id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "select _id, titulo, data, hora, urgente, importante, detalhes from " + TarefaDBHelper.TABELA + " where _id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
        cursor.moveToFirst();
        Tarefa tarefa = new Tarefa();
        tarefa.setId(cursor.getLong(0));
        tarefa.setTitulo(cursor.getString(1));
        tarefa.setData(cursor.getString(2));
        tarefa.setHora(cursor.getLong(3));
        tarefa.setUrgente(Boolean.parseBoolean(cursor.getString(4)));
        tarefa.setImportante(Boolean.parseBoolean(cursor.getString(5)));
        tarefa.setDetalhes(cursor.getString(6));
        db.close();
        return tarefa;
    }

    public void remover(Long id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String deletar = "delete from " + TarefaDBHelper.TABELA + " where _id = ?";
        db.execSQL(deletar, new Object[]{id});
        db.close();
    }

}