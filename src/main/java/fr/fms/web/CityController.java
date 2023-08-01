package fr.fms.web;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import fr.fms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
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
}
