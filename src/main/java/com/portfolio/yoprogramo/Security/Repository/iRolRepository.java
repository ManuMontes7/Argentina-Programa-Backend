package com.portfolio.yoprogramo.Security.Repository;

import com.portfolio.yoprogramo.Security.Entity.Rol;
import com.portfolio.yoprogramo.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);

    public Optional<Rol> findbyRolNombre(RolNombre rolNombre);
}