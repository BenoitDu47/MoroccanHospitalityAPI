package fr.fms.security.service;

import fr.fms.security.entities.AppRole;
import fr.fms.security.entities.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username,String rolename);
    public AppUser findUserByUsername(String username);
    ResponseEntity<List<AppUser>> listUsers();
}
