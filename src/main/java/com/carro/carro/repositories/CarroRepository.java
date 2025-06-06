package com.carro.carro.repositories;

import com.carro.carro.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}