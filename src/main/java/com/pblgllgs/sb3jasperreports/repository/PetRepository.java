package com.pblgllgs.sb3jasperreports.repository;


import com.pblgllgs.sb3jasperreports.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}