
package br.edu.ifpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Banda implements Serializable{
    
    private int id;
    private String nome;
    private String localDeOrigem;
    private List<String> integrantes;

    public Banda() {
    }

    public Banda(int id, String nome, String localDeOrigem, List<String> integrantes) {
        this.id = id;
        this.nome = nome;
        this.localDeOrigem = localDeOrigem;
        this.integrantes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return nome;
    }
}
