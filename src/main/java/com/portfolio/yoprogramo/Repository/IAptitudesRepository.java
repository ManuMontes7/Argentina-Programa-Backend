package com.portfolio.yoprogramo.Repository;

import com.portfolio.yoprogramo.Entity.Aptitudes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAptitudesRepository extends JpaRepository<Aptitudes, Integer>{
    Optional<Aptitudes> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}