package com.portfolio.yoprogramo.Service;

import com.portfolio.yoprogramo.Entity.Aptitudes;
import com.portfolio.yoprogramo.Repository.IAptitudesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AptitudesService {

    @Autowired
    IAptitudesRepository aptitudesRepository;

    public List<Aptitudes> list() {
        return aptitudesRepository.findAll();
    }

    public Optional<Aptitudes> getOne(int id) {
        return aptitudesRepository.findById(id);
    }

    public Optional<Aptitudes> getByNombre(String nombre) {
        return aptitudesRepository.findByNombre(nombre);
    }

    public void save(Aptitudes skill) {
        aptitudesRepository.save(skill);
    }

    public void delete(int id) {
        aptitudesRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return aptitudesRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return aptitudesRepository.existsByNombre(nombre);
    }
}
