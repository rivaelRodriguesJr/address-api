package com.api.adress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.adress.entities.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {

}
