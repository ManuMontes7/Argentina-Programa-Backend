package com.portfolio.yoprogramo.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyectos {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String img;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombrePro, String descripcionPro, String img) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.img = img;
    }
}