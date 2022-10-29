package com.portfolio.yoprogramo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePro;
    private String descripcionPro;
    private String img;

    public Proyectos() {
    }

    public Proyectos(String nombrePro, String descripcionPro, String img) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.img = img;
    }
}
