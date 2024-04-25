package com.carros.v2Java.repository;

import com.carros.v2Java.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
