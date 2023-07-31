package fr.fms;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiMoroccanHospitalityApplication implements CommandLineRunner {
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private CityRepository cityRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiMoroccanHospitalityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		generateDatas();
	}

	private void generateDatas() {

		City Fes = cityRepository.save(new City(null,"Fés",null));
		City Casablanca = cityRepository.save(new City(null,"Casablanca",null));
		City Marrakech = cityRepository.save(new City(null,"Marrakech",null));
		City Tanger = cityRepository.save(new City(null,"Tanger",null));
		City Rabat = cityRepository.save(new City(null,"Rabat",null));
		City Agadir = cityRepository.save(new City(null,"Agadir",null));
		City Essaouira = cityRepository.save(new City(null,"Essaouira",null));

		hotelRepository.save(new Hotel(null,"La Mamounia","Hôtel raffiné, ancien domaine royal du XIIe siècle, proche de Jemaa el-Fna et Koutoubia. Chambres sophistiquées, restaurants élégants, spa, salle de sport et jardins.", "Avenue Bab Jdid, Marrakesh 40040, Maroc","+212 5243-88600",5,480,8,"unknown.png",null,Marrakech ));
		hotelRepository.save(new Hotel(null,"Royal Mansour Marrakech","Hôtel de luxe situé à proximité de la médina de Marrakech et de l'aéroport. Restaurants gastronomiques, piscines intérieure et extérieure, spa, club enfants.", "Rue Abou Abbas El Sebti، 40000, Maroc","+212 52980-8080",5,560,4,"unknown.png",null,Marrakech ));
		hotelRepository.save(new Hotel(null,"Four Seasons Hotel Casablanca","Hôtel haut de gamme offrant une vue sur la plage Lalla Meryem et l'océan Atlantique Nord. ", "Boulevard de la Corniche, Casablanca, Maroc","+212 5290-73700",4,249,6,"unknown.png",null,Casablanca ));



	}

}
