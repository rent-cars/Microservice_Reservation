package com.rentcars.reservations.web.controller;

import com.rentcars.reservations.web.model.Reservations;
import com.rentcars.reservations.web.repository.ReservationsRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
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
    public Reservations getReservations(@PathVariable int id) {
        return reservationsRepository.findById(id);
    }

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
