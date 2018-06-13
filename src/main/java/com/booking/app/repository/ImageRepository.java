package com.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.app.model.Image;


@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
