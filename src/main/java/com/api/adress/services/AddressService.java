package com.api.adress.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.adress.dto.AddressDTO;
import com.api.adress.entities.Address;
import com.api.adress.repositories.AddressRepository;
import com.api.adress.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Transactional(readOnly = true)
	public List<AddressDTO> findAll() {
		return repository.findAll().stream().map(entity -> new AddressDTO(entity)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AddressDTO findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		Address entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO insert(AddressDTO dto) {
		Address entity = new Address();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO update(Long id, AddressDTO dto) {
		try {
			Address entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AddressDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	private void copyDtoToEntity(AddressDTO dto, Address entity) {
		entity.setId(dto.getId());
		entity.setStreetName(dto.getStreetName());
		entity.setNumber(dto.getNumber());
		entity.setComplement(dto.getComplement());
		entity.setNeighbourhood(dto.getNeighbourhood());
		entity.setCity(dto.getCity());
		entity.setState(dto.getState());
		entity.setCountry(dto.getCountry());
		entity.setZipcode(dto.getZipcode());
		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());
	}
}
