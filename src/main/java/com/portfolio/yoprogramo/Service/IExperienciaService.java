package com.portfolio.yoprogramo.Service;

import com.portfolio.yoprogramo.Entity.Experiencia;
import com.portfolio.yoprogramo.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IExperienciaService {

    @Autowired
    IExperienciaRepository iexperienciaRepository;

    public List<Experiencia> list() {
        return iexperienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return iexperienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombreExp(String nombreExp) {
        return iexperienciaRepository.findByNombreExp(nombreExp);
    }

    public void save(Experiencia exp) {
        iexperienciaRepository.save(exp);
    }

    public void delete(int id) {
        iexperienciaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iexperienciaRepository.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp) {
        return iexperienciaRepository.existsByNombreExp(nombreExp);
    }
}
