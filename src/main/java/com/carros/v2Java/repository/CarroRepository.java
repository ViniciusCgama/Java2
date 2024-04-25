package com.carros.v2Java.repository;

import com.carros.v2Java.model.Carro;
import com.carros.v2Java.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
