package fr.fms.service;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    City getCity(Long id);

    List<Hotel> getHotels();

    Hotel saveHotel(Hotel hotel);

    public Optional<Hotel> readHotel(Long id);

    void deleteHotel(Long id);

    List<City> getCities();

    List<Hotel> getHotelsByCityId(Long id);

    City saveCity(City city);

    public Optional<City> readCity(Long id);

    void deleteCity(Long id);
}
