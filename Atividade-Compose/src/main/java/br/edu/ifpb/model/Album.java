
package br.edu.ifpb.model;

import java.io.Serializable;

public class Album implements Serializable{
    
    private int id;
    private Estilo estilo;
    private int banda;
    private String nomeBanda;
    private String anoDeLancamento;

    public Album() {
    }

    public Album(int id, Estilo estilo, int banda, String nomeBanda, String anoDeLancamento) {
        this.id = id;
        this.estilo = estilo;
        this.banda = banda;
        this.nomeBanda = nomeBanda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public int getBanda() {
        return banda;
    }

    public void setBanda(int banda) {
        this.banda = banda;
    }

    public String getNomeBanda() {
        return nomeBanda;
    }

    public void setNomeBanda(String nomeBanda) {
        this.nomeBanda = nomeBanda;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
   
}