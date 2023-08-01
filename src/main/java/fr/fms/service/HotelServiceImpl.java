package fr.fms.service;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    @Override
    public Optional<Hotel> readHotel(Long id) {
        return hotelRepository.findById(id);
    }
    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }


    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }
    @Override
    public List<Hotel> getHotelsByCityId(Long id) {
        return hotelRepository.findByCityId(id);
    }
    @Override
    public City getCity(Long id) {
        return cityRepository.getById(id);
    }
}
