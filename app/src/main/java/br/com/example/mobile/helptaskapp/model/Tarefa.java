package br.com.example.mobile.helptaskapp.model;

import java.util.Date;

public class Tarefa {

    private int id;
    private String titulo;
    private Date data;
    private boolean urgente;
    private boolean importante;
    private String detalhes;

    public Tarefa(){}

    public Tarefa(int id, String titulo, Date data, boolean urg, boolean imp, String detalhes){
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.urgente = urg;
        this.importante = imp;
        this.detalhes = detalhes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public boolean isImportante() {
        return importante;
    }

    public void setImportante(boolean importante) {
        this.importante = importante;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
