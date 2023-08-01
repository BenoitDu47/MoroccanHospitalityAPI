package fr.fms.web;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import fr.fms.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@Slf4j
public class CityController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/cities")
    public List<City> allCities() {
        return hotelService.getCities();
    }

    @GetMapping("/cities/{id}/hotels")
    public List<Hotel> allHotelsByCityId(@PathVariable("id") Long id) {
        return hotelService.getHotelsByCityId(id);
    }

    @PostMapping("/cities")
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        City savedCity = hotelService.saveCity(city);
        if (Objects.isNull(savedCity)) {
            return ResponseEntity.noContent().build();
        }
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/cities")
    public ResponseEntity<City> updateCity(@RequestBody City c) {
        City existingCity = hotelService.readCity(c.getId()).get();
        existingCity.setName(c.getName());

        if (Objects.isNull(hotelService.saveCity(existingCity))) {
            return ResponseEntity.noContent().build();
        }
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(existingCity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/cities/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        try {
            hotelService.deleteCity(id);
        } catch (Exception e) {
            log.error("Problème avec la suppression de la ville d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        log.info("Suppression de la ville d'id : {}", id);
        return ResponseEntity.ok().build();
    }
}
