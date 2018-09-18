package br.com.example.mobile.helptaskapp.model;

import android.support.annotation.NonNull;

public class Tarefa {

    private Long id;
    private String titulo;
    private String data;
    private int hora;
    private boolean urgente;
    private boolean importante;
    private String detalhes;

    public Tarefa(){}

    public Tarefa (Long id){this.id = id;}

    public Tarefa(Long id, String titulo, String data, int hora, boolean urg, boolean imp, String detalhes){
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.urgente = urg;
        this.importante = imp;
        this.detalhes = detalhes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Tarefa)) return false;

        Tarefa tarefa = (Tarefa) o;

        if(!id.equals(tarefa.id)) return false;

        return true;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
    
    public int compareTo(@NonNull Tarefa x){
        return titulo.toLowerCase().compareTo(x.titulo.toLowerCase());
    }
}
