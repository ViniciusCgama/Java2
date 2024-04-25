package com.carros.v2Java.service;

import com.carros.v2Java.model.Carro;
import com.carros.v2Java.model.Cor;
import com.carros.v2Java.model.Marca;
import com.carros.v2Java.repository.CarroRepository;
import com.carros.v2Java.repository.CorRepository;
import com.carros.v2Java.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private final MarcaRepository marcaRepository;
    private final CorRepository corRepository;

    public CarroService(CarroRepository carroRepository, MarcaRepository marcaRepository, CorRepository corRepository) {
        this.carroRepository = carroRepository;
        this.marcaRepository = marcaRepository;
        this.corRepository = corRepository;
    }

    @Transactional
    public String cadastrarCarro(String nomeCarro, int anoFabricacaoCarro, int anoModeloCarro, String modeloCarro, Long idMarca, List<Cor> idsCores)
    {
        Carro carro = new Carro();
        carro.setNomeCarro(nomeCarro);
        carro.setAnoFabricacaoCarro(anoFabricacaoCarro);
        carro.setAnoModeloCarro(anoModeloCarro);
        carro.setModeloCarro(modeloCarro);

        Optional<Marca> optionalMarca = marcaRepository.findById(idMarca);
        if (optionalMarca.isPresent()) {
            carro.setMarca(optionalMarca.get());
        } else {
            return "Marca não encontrada";
        }

        List<Long> corIds = idsCores.stream()
                .map(Cor::getIdCor)
                .collect(Collectors.toList());

        List<Cor> cores = corRepository.findAllById(corIds);
        carro.setCores(cores);


        carroRepository.save(carro);

        return "Carro cadastrado com sucesso";
    }
}