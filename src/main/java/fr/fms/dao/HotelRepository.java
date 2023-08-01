package fr.fms.dao;

import fr.fms.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    public List<Hotel> findByCityId(Long CityId);
}
