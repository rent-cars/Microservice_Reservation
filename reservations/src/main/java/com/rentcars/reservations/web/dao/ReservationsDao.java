package com.rentcars.reservations.web.dao;

import com.rentcars.reservations.web.model.Reservations;
import com.rentcars.reservations.web.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/reservations")
@RestController
@Repository


public interface ReservationsDao extends JpaRepository<Reservations, Integer> {
    List<Reservations> findAll();
    Reservations findById(int id);
    Reservations save(Reservations reservations);

}
