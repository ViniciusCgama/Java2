package com.carros.v2Java.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro")
    private Long idCarro;

    @Column(nullable = false, name = "nomecarro")
    private String nomeCarro;

    @Column(nullable = false, name = "anofabricacaocarro")
    private int anoFabricacaoCarro;

    @Column(nullable = false, name = "anomodelocarro")
    private int anoModeloCarro;

    private String modeloCarro;

    @ManyToOne
    @JoinColumn(name = "idmarca", nullable = false)
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "carro_cor",
            joinColumns = @JoinColumn(name = "idcarro"),
            inverseJoinColumns = @JoinColumn(name = "idcor"))
    private List<Cor> cores;

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public int getAnoFabricacaoCarro() {
        return anoFabricacaoCarro;
    }

    public void setAnoFabricacaoCarro(int anoFabricacaoCarro) {
        this.anoFabricacaoCarro = anoFabricacaoCarro;
    }

    public int getAnoModeloCarro() {
        return anoModeloCarro;
    }

    public void setAnoModeloCarro(int anoModeloCarro) {
        this.anoModeloCarro = anoModeloCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Cor> getCores() {
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }
}

