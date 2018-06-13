package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
