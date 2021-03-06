package com.api.adress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.adress.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
