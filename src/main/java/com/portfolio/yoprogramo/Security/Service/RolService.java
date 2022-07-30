package com.portfolio.yoprogramo.Security.Service;

import com.portfolio.yoprogramo.Security.Entity.Rol;
import com.portfolio.yoprogramo.Security.Enums.RolNombre;
import com.portfolio.yoprogramo.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return irolRepository.findbyRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}