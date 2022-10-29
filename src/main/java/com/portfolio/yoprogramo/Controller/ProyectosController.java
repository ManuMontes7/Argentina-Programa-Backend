package com.portfolio.yoprogramo.Controller;

import com.portfolio.yoprogramo.Dto.DtoProyectos;
import com.portfolio.yoprogramo.Entity.Proyectos;
import com.portfolio.yoprogramo.Security.Controller.Mensaje;
import com.portfolio.yoprogramo.Service.ProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portfolioargprograma-9af25.web.app")
public class ProyectosController {
    
    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no existente"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no existente"), HttpStatus.NOT_FOUND);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyectosService.existsByNombrePro(dtoproyectos.getNombrePro())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoproyectos.getNombrePro(), dtoproyectos.getDescripcionPro(), dtoproyectos.getImg());
        proyectosService.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproyectos) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no existente"), HttpStatus.NOT_FOUND);
        }
        if (proyectosService.existsByNombrePro(dtoproyectos.getNombrePro()) && proyectosService.getByNombrePro(dtoproyectos.getNombrePro()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyectos.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombrePro(dtoproyectos.getNombrePro());
        proyectos.setDescripcionPro(dtoproyectos.getDescripcionPro());
        proyectos.setImg(dtoproyectos.getImg());

        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}