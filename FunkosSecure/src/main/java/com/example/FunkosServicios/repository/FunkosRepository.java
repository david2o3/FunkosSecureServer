package com.example.FunkosServicios.repository;

import com.example.FunkosServicios.models.Funko;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FunkosRepository extends JpaRepository<Funko, Long> {

    Funko findByCod(String cod);

    List<Funko> findByModelo(String modelo);

    List<Funko> findByFechaLanzamientoYear(int year);
}
