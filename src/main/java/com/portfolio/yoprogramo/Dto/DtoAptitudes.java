package com.portfolio.yoprogramo.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoAptitudes {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoAptitudes() {
    }

    public DtoAptitudes(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
}
