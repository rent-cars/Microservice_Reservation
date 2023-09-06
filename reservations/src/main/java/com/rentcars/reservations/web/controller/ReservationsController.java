package com.rentcars.reservations.web.controller;

import com.rentcars.reservations.web.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired

    private ReservationsRepository reservationsRepository;
    RestTemplate restTemplate = new RestTemplate();

    public ReservationsController(ReservationsRepository reservationsRepository) {this.reservationsRepository = reservationsRepository;}






}
