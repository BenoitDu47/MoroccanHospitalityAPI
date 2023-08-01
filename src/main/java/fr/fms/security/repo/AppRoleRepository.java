package fr.fms.security.repo;

import fr.fms.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRolename(String rolename);    //renvoi à partir de roleName l'objet AppRole correspondant
}
