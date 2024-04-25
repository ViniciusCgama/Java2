package com.carros.v2Java.controller;

import com.carros.v2Java.model.Marca;
import com.carros.v2Java.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/marca")
public class MarcaResource {

    private final MarcaService marcaService;

    public MarcaResource(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @RequestMapping (value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<String> inserirCor(@Validated @RequestBody Marca marca) {
        String mensagem = marcaService.inserirMarca(marca.getNomeMarca());
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @RequestMapping (value = "/pegar", method = RequestMethod.GET)
    public ResponseEntity<List<Marca>> listarMarcas() {
        List<Marca> marcas = marcaService.listarMarcas();
        return ResponseEntity.status(HttpStatus.OK).body(marcas);
    }
}
