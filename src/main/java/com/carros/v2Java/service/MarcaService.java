package com.carros.v2Java.service;

import com.carros.v2Java.model.Marca;
import com.carros.v2Java.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }

    public String inserirMarca(String nomemarca) {
        Marca marca = new Marca();
        marca.setNomeMarca(nomemarca);

        Marca novaMarca = marcaRepository.save(marca);

        if (novaMarca != null) {
            return "Marca inserida com sucesso";
        } else {
            return "Erro ao inserir marca";
        }
    }

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }
}
