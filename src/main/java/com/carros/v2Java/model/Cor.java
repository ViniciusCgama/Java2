package com.carros.v2Java.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cor")
public class Cor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idcor")
    private Long idCor;

    @Column (nullable = false, name = "nomecor")
    private String nomeCor;

    @ManyToMany (mappedBy = "cores")
    private List<Carro> carros;

    public Long getIdCor() {
        return idCor;
    }

    public void setIdCor(Long idCor) {
        this.idCor = idCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }

    public void setNomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
