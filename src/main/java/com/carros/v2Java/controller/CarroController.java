package com.carros.v2Java.controller;

import com.carros.v2Java.model.Carro;
import com.carros.v2Java.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<String> criarCarro(@RequestBody Carro carro) {
        try {
            String result = carroService.cadastrarCarro(
                    carro.getNomeCarro(),
                    carro.getAnoFabricacaoCarro(),
                    carro.getAnoModeloCarro(),
                    carro.getModeloCarro(),
                    carro.getMarca() != null ? carro.getMarca().getIdMarca() : null,
                    carro.getCores()
            );
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar carro: " + e.getMessage());
        }
    }
}