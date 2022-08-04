package com.portfolio.yoprogramo.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }
}
