package fr.fms.dao;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

}
