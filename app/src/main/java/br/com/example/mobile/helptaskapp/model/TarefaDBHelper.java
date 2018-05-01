package br.com.example.mobile.helptaskapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TarefaDBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "db.tarefas.db";

    public static final String TABELA = "tarefas";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String DATA = "data";
    public static final String HORA = "hora";
    public static final String URGENTE = "urgente";
    public static final String IMPORTANTE = "importante";
    public static final String DETALHES = "detalhes";

    private static final int VERSAO = 1;

    public TarefaDBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String criarDB = "create table " + TABELA + "(" + ID
                + " integer primary key autoincrement," + TITULO
                + " text," + DATA + " text," + HORA + " long,"
                + URGENTE + " text," + IMPORTANTE + " text,"
                + DETALHES + " text)";
        sqLiteDatabase.execSQL(criarDB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        int versao = sqLiteDatabase.getVersion();
//        switch (versao){
//            case 1:
//                sqLiteDatabase.execSQL("ALTER TABLE " + TABELA);
        }
}