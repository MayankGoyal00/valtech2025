package com.valtech.hackathon.vehicle.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Vehicle {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "veh_seq")
	@SequenceGenerator(name = "veh_seq",sequenceName = "veh_seq",allocationSize = 1)
	private Long id;
	
	private String vehicleNumber;
	private String model;
	private String manufacture;
	
	
	public Vehicle() {
	}
	
	
	public Vehicle(String vehicleNumber, String model, String manufacture) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.manufacture = manufacture;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	
	

}
