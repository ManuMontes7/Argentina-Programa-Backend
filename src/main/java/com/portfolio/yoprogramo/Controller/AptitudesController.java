package com.portfolio.yoprogramo.Controller;

import com.portfolio.yoprogramo.Dto.DtoAptitudes;
import com.portfolio.yoprogramo.Entity.Aptitudes;
import com.portfolio.yoprogramo.Security.Controller.Mensaje;
import com.portfolio.yoprogramo.Service.AptitudesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aptitudes")
@CrossOrigin(origins = "https://portfolioargprograma-9af25.web.app")

public class AptitudesController {
    @Autowired
    AptitudesService aptitudesService;

    @GetMapping("/lista")
    public ResponseEntity<List<Aptitudes>> list() {
        List<Aptitudes> list = aptitudesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Aptitudes> getById(@PathVariable("id") int id) {
        if (!aptitudesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Aptitudes aptitudes = aptitudesService.getOne(id).get();
        return new ResponseEntity(aptitudes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!aptitudesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        aptitudesService.delete(id);
        return new ResponseEntity(new Mensaje("Wliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAptitudes dtoAptitudes) {
        if (StringUtils.isBlank(dtoAptitudes.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (aptitudesService.existsByNombre(dtoAptitudes.getNombre())) {
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        }

        Aptitudes aptitudes = new Aptitudes(dtoAptitudes.getNombre(), dtoAptitudes.getPorcentaje());
        aptitudesService.save(aptitudes);

        return new ResponseEntity(new Mensaje("Agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoAptitudes dtoAptitudes) {
        if (!aptitudesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (aptitudesService.existsByNombre(dtoAptitudes.getNombre()) && aptitudesService.getByNombre(dtoAptitudes.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoAptitudes.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Aptitudes aptitudes = aptitudesService.getOne(id).get();
        aptitudes.setNombre(dtoAptitudes.getNombre());
        aptitudes.setPorcentaje(dtoAptitudes.getPorcentaje());

        aptitudesService.save(aptitudes);
        return new ResponseEntity(new Mensaje("Actualizado"), HttpStatus.OK);

    }
}
