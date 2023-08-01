package fr.fms.service;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> getHotels();

    City getCity(Long id);

    Hotel saveHotel(Hotel hotel);

    public Optional<Hotel> readHotel(Long id);

    void deleteHotel(Long id);

    List<City> getCities();

    List<Hotel> getHotelsByCityId(Long id);
}
