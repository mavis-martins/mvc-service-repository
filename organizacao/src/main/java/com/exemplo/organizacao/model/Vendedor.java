package com.exemplo.organizacao.model;

import jakarta.persistence.*;

@Entity
public class Vendedor extends Pessoa {

    @Column(name = "numero_matricula", unique = true)
    private String numeroMatricula;

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
