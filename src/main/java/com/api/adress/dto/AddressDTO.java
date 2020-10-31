package com.api.adress.dto;

import java.io.Serializable;

import com.api.adress.entities.Address;

import javax.validation.constraints.NotNull;

public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "Mandatory field")
	private String streetName;

	@NotNull(message = "Mandatory field")
	private Integer number;

	private String complement;

	@NotNull(message = "Mandatory field")
	private String neighbourhood;

	@NotNull(message = "Mandatory field")
	private String city;

	@NotNull(message = "Mandatory field")
	private String state;

	@NotNull(message = "Mandatory field")
	private String country;

	@NotNull(message = "Mandatory field")
	private String zipcode;

	private Double latitude;

	private Double longitude;

	public AddressDTO() {
	}

	public AddressDTO(Address entity) {
		this.id = entity.getId();
		this.streetName = entity.getStreetName();
		this.number = entity.getNumber();
		this.complement = entity.getComplement();
		this.neighbourhood = entity.getNeighbourhood();
		this.city = entity.getCity();
		this.state = entity.getState();
		this.country = entity.getCountry();
		this.zipcode = entity.getZipcode();
		this.latitude = entity.getLatitude();
		this.longitude = entity.getLongitude();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
