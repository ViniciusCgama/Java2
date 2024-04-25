package com.carros.v2Java.service;

import com.carros.v2Java.model.Cor;
import com.carros.v2Java.repository.CorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorService {

    private final CorRepository corRepository;

    public CorService(CorRepository corRepository) {
        this.corRepository = corRepository;
    }

    public String inserirCor(String nomecor) {
        Cor cor = new Cor();
        cor.setNomeCor(nomecor);

        Cor novaCor = corRepository.save(cor);

        if (novaCor != null) {
            return "Cor inserida com sucesso";
        } else {
            return "Erro ao inserir cor";
        }
    }

    public List<Cor> listarCores() {
        return corRepository.findAll();
    }
}
