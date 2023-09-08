package com.rentcars.reservations.web.controller;

import com.rentcars.reservations.web.model.Clients;
import com.rentcars.reservations.web.model.Reservations;
import com.rentcars.reservations.web.model.Vehicle;
import com.rentcars.reservations.web.repository.ReservationsRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;


@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired

    private ReservationsRepository reservationsRepository;
    RestTemplate restTemplate = new RestTemplate();

    public ReservationsController(ReservationsRepository reservationsRepository) {this.reservationsRepository = reservationsRepository;
    }

    @ApiOperation(value = "Renvoyer la liste des réservations")
    @GetMapping
    public List<Reservations> listReservations() {
        return reservationsRepository.findAll();
    }

    @ApiOperation(value = "Renvoyer les infos d'une réservation correspondant à l'identifiant (id) choisi")
    @GetMapping("/{id}")
    public Reservations getReservations(@PathVariable int id, Date startDate) {
        return reservationsRepository.findById(id);
        //    afficherstartdate(resa)
//        print(resa.getstartdate)
        if (reservationsRepository != null) {
            startDate = reservationsRepository.getStartDate();
            return startDate;
        }

    }
    @GetMapping("/vehicule-available/{startDate}/{endDate}")
    public List<Vehicle> getListAvailbleVehicle(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {
        RestTemplate restTemplate = new RestTemplate();
        List<Vehicle> vehicleList = restTemplate.getForObject("http://192.168.1.236:9091/vehicles", List.class);

        getUnavailbleRegistrationVehicles(startDate, endDate);
        return null;
    }

    private List<String> getUnavailbleRegistrationVehicles(Date startDate, Date endDate) {
        List<Reservations> reservationList = reservationsRepository.findAll();
        List<String> result = new ArrayList<>();
        for(Reservations reservation : reservationList){
            if(reservation.getStartDate().before(endDate) && reservation.getStartDate().after(startDate)){
                result.add(reservation.getRegistrationVehicle());
            }
        }

        return result;
    }
//   public isAvailable (reservations){
//       reservationrepo.requete( resa.stardate resa.enddate resa.vehicule);
//       return ;
//   }


    @ApiOperation(value = "Ajoute une nouvelle réservation")
    @PostMapping
    public Reservations addReservations(@RequestBody Reservations newReservations) {
        // exceptionValidation(newReservation);
        //Si true == save la nouvelle reservation :
        return reservationsRepository.save(newReservations);
    }

    @ApiOperation(value = "Modifier une réservation de la liste")
    @PutMapping("/{id}")
    public Reservations updateReservation (@PathVariable int id, @RequestBody Reservations reservations) {
        reservations.setId(id);
        return reservationsRepository.save(reservations);
    }

    @ApiOperation(value = "Supprimer une réservation de la liste")
    @DeleteMapping("/{id}")
    public void deleteReservations(@PathVariable int id) {
        reservationsRepository.deleteById(id);
    }


    //Récupère dans le microservice Clients, l'id du client
    public Clients getClients(int client_id) {
        Clients client = restTemplate.getForObject("http://192.168.1.236:9090/clients/" + client_id, Clients.class);
        return client;
    }

    //Récupère dans le microservice Vehicle, l'id du véhicule (=plaque d'immatriculation = "registration")
    public Vehicle getVehicle(String registration) {
        Vehicle vehicle = restTemplate.getForObject("http://192.168.1.236:9091/vehicles/" + registration, Vehicle.class);
        return vehicle;
    }

    //Récupère dans le microservice Vehicle, la puissance en chevaux fiscaux des véhicules
    public Vehicle[] getVehicleMaxHp(int horsepowerTax){
        ResponseEntity<Vehicle[]> response = restTemplate.getForEntity("http://192.168.1.236:9091/vehicles/%22"+ horsepowerTax, Vehicle[].class);
        Vehicle[] vehicles = response.getBody();
        return  vehicles;
    }

//    @ApiOperation(value = "Récupère dans le microservice Reservations, la date de début et la date de fin de la réservation")
//    @GetMapping("/{id}")
//    public Reservations getStartDate(@PathVariable int id){
//    return reservationsRepository.findById(id);
//    }
//Chemin de l'adresse pour la requête:'
//get/id/startDate ???




    //Calcul prix final voiture
 /*   private final Vehicle vehicleSelected;
    public float finalPriceCar (int nbKms) {
        int currentPrice = this.vehicleSelected.getCurrentPrice();
        float priceKms = this.vehicleSelected.getPricePerKms();
        float totalPrice=currentPrice+(priceKms*nbKms);
        return totalPrice;
    }*/



    // Calcul âge conducteur

   /* LocalDate dateOfBirth = LocalDate.of(1969, Month.SEPTEMBER, 11);
    LocalDate now = LocalDate.now();
    int age = dateOfBirth.until(now).getYears();*/


}
