package com.carros.v2Java.controller;

import com.carros.v2Java.model.Cor;
import com.carros.v2Java.model.Marca;
import com.carros.v2Java.service.CorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/cor")
public class CorResource {

    private final CorService corService;

    public CorResource(CorService corService) {
        this.corService = corService;
    }

    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<String> inserirCor(@Validated @RequestBody Cor cor) {
        String mensagem = corService.inserirCor(cor.getNomeCor());
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @RequestMapping (value = "/pegar", method = RequestMethod.GET)
    public ResponseEntity<List<Cor>> listarCores() {
        List<Cor> cores = corService.listarCores();
        return ResponseEntity.status(HttpStatus.OK).body(cores);
    }
}