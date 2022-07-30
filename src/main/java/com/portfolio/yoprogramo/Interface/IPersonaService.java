package com.portfolio.yoprogramo.Interface;

import com.portfolio.yoprogramo.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    // Trae una lista de personas
    public List<Persona> getPersona();
    
    // Guardar una persona
    public void savePersona(Persona persona);
    
    // Eliminar un usuario por Id
    public void deletePersona(Long id);
    
    //Buscar una persona por Id
    public Persona findPersona(Long id);
}
