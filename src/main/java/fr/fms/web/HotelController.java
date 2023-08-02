package fr.fms.web;

import fr.fms.entities.Hotel;
import fr.fms.exception.RecordNotFoundException;
import fr.fms.service.HotelService;
import fr.fms.service.HotelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@Slf4j
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelServiceImpl hotelServiceImpl;

    @GetMapping("/hotels")
    public List<Hotel> allHotels() {
        return hotelServiceImpl.getHotels();
    }

    @GetMapping("/hotel/{id}")
    public Hotel getHotelById(@PathVariable("id") Long id) {
        return hotelService.readHotel(id)
                .orElseThrow(() -> new RecordNotFoundException("L'hôtel avec l'ID " + id + " n'existe pas"));
    }

    @PostMapping("/hotel-form")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        hotel.setCity(hotelService.getCity(hotel.getCity().getId()));
        Hotel savedHotel = hotelService.saveHotel(hotel);
        if(Objects.isNull(savedHotel)) {
            return ResponseEntity.noContent().build();
        }
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedHotel.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/hotel-form/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel h, @PathVariable("id") Long id) {
        Hotel existingHotel = hotelService.readHotel(id)
                .orElseThrow(() -> new RecordNotFoundException("L'hôtel avec l'ID " + id + " n'existe pas"));

        existingHotel.setName(h.getName());
        existingHotel.setDescription(h.getDescription());
        existingHotel.setAddress(h.getAddress());
        existingHotel.setPhone(h.getPhone());
        existingHotel.setStars(h.getStars());
        existingHotel.setPrice(h.getPrice());
        existingHotel.setNumberOfRoom(h.getNumberOfRoom());
        existingHotel.setCity(hotelService.getCity(h.getCity().getId()));

        Hotel updatedHotel = hotelService.saveHotel(existingHotel);
        if (Objects.isNull(updatedHotel)) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedHotel.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(value = "/hotels/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable("id") Long id) {
        try {
            hotelService.deleteHotel(id);
        }
        catch (Exception e) {
            log.error("Problème avec la suppression de l'hôtel d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        log.info("Suppression de l'hôtel d'id : {}", id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/photo/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> getPhoto(@PathVariable("id") Long id) throws IOException {
        byte[] file = null;
        try {
            Hotel hotel = hotelService.readHotel(id).get();
            if (hotel.getPhoto() == null) hotel.setPhoto("unknown.png");
            file = Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/hotels/images/" + hotel.getPhoto()));
        } catch (Exception e) {
            log.error("Problème avec le téléchargement de l'image correspondant à l'hôtel d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        return ResponseEntity.ok().body(file);
    }

    @PostMapping(path = "/photo/{id}")
    public ResponseEntity<?> uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
        try {
            Hotel hotel = hotelService.readHotel(id).get();
            hotel.setPhoto(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home") + "/hotels/images/" + hotel.getPhoto()), file.getBytes());
            hotelService.saveHotel(hotel);
        } catch (Exception e) {
            log.error("Problème avec le téléchargement de l'image correspondant à l'hôtel d'id : {}", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        log.info("file upload ok {}", id);
        return ResponseEntity.ok().build();
    }

}
