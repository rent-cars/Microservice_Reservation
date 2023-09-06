package com.rentcars.reservations.web.repository;

import com.rentcars.reservations.web.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {
    List<Reservations> findAll();
    Reservations findById(int id);
    Reservations save(Reservations reservations);
    Reservations deleteByid(int id);

}
