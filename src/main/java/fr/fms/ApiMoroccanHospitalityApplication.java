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
		// generateDatas();
	}

	private void generateDatas() {

		City fes = cityRepository.save(new City(null,"Fés",null));
		City casablanca = cityRepository.save(new City(null,"Casablanca",null));
		City marrakech = cityRepository.save(new City(null,"Marrakech",null));
		City tanger = cityRepository.save(new City(null,"Tanger",null));
		City rabat = cityRepository.save(new City(null,"Rabat",null));
		City agadir = cityRepository.save(new City(null,"Agadir",null));
		City essaouira = cityRepository.save(new City(null,"Essaouira",null));

		hotelRepository.save(new Hotel(null,"La Mamounia","Hotel raffiné, ancien domaine royal du XIIe siècle, proche de Jemaa el-Fna et Koutoubia. Chambres sophistiquées, restaurants élégants, spa, salle de sport et jardins.", "Avenue Bab Jdid, Marrakesh 40040, Morocco","+212 5243-88600",4,480,8,"unknown.png",null,marrakech));
		hotelRepository.save(new Hotel(null,"Royal Mansour Marrakech","Hotel de luxe situé à proximité de la médina de Marrakech et de l'aéroport. Restaurants gastronomiques, piscines intérieure et extérieure, spa, club enfants.", "Rue Abou Abbas El Sebti, 40000, Morocco","+212 52980-8080",5,560,4,"unknown.png",null,marrakech));
		hotelRepository.save(new Hotel(null,"Four Seasons Hotel Casablanca","Hotel haut de gamme offrant une vue sur la plage Lalla Meryem et l'océan Atlantique Nord. ", "Boulevard de la Corniche, Casablanca, Morocco","+212 5290-73700",4,249,6,"unknown.png",null,casablanca));
		hotelRepository.save(new Hotel(null,"Karawan riad","Riad imposant du XVIIe siècle, ancien harem, situé à proximité de Jnan Sbil et de la synagogue Ibn Danan.", "21 Derb Ourbia Makhfiya, Fes 30000, Morocco","+212 5356-37878",4,159,3,"unknown.png",null,fes));
		hotelRepository.save(new Hotel(null,"Grand Mogador Tanger","Certifié HotelCert International, vue panoramique sur la montagne et le détroit, piscine extérieure, hammam, sauna, salle de sport, chambres climatisées avec minibar et télévision.", "10, Lotissement Al Ghandouri, Av. du Front de Mer, Tangier 90000, Morocco","+212 530-530530",4,349,1,"unknown.png",null,tanger));
		hotelRepository.save(new Hotel(null, "Fairmont Tazi Palace Tangier", "Notre majestueux palais niché sur les collines surplombant la médina offre un cadre enchanteur avec un jardin d'eucalyptus centenaires et un rooftop.", "Palais Tazi, Jamaa Mokrae Quartier Boubana, Tanger, Morocco", "+212 5393-78989", 3, 299, 5, "unknown.png", null, tanger));
		hotelRepository.save(new Hotel(null, "Hotel et résidences Fairmont La Marina Rabat Sale", "Fairmont La Marina Rabat-Sale : hôtel moderne, vue sur le fleuve et l'océan, capitale historique du Maroc.", "La Marina, Avenue de Fes, Rabat 11000, Morocco", "+212 5378-20800", 2, 400, 2, "unknown.png", null, rabat));
		hotelRepository.save(new Hotel(null, "Les Dunes d'Or", "Situé en face de la plage d'Agadir, cet hôtel sophistiqué tout compris se trouve à 3 km du musée de la Culture Amazigh et du jardin du Portugal.", "Chemin des dunes, Agadir 80000, Morocco", "+212 5290-80121", 4, 180, 8, "unknown.png", null, agadir));
		hotelRepository.save(new Hotel(null,"Suite Azur Hotel","Détente et luxe en plein cœur de la médina d'Essaouira, à quelques mètres de la place centrale Moulay Hassan. 16 chambres exceptionnelles.", "N° 2 Rue Oum Rabii, Essaouira, Morocco","+212 5244-76128",3,149,3,"unknown.png",null,essaouira));
		hotelRepository.save(new Hotel(null,"Ryad Watier","Hôtel détendu, maison marocaine traditionnelle, proche plage, chambres sobres, suites colorées, vue jardin, suites familiales pour 4-5 personnes.", "16 Rue Ceuta, Essaouira 44000, Morocco","+212 5244-76204",3,129,3,"unknown.png",null,essaouira));
	}

}
