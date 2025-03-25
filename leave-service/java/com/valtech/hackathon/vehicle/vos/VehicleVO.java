package com.valtech.hackathon.vehicle.vos;

import com.valtech.hackathon.vehicle.entities.Vehicle;

public record VehicleVO(Long id, String vehicleNumber, String model, String manufacturer) {
	public static VehicleVO from(Vehicle ve) {
		return new VehicleVO(
				ve.getId(),
				ve.getModel(),
				ve.getManufacture(),
				ve.getVehicleNumber()
				);
	}

	public Vehicle to() {
		Vehicle vehicle= new Vehicle();
		vehicle.setId(id);
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setModel(model);
		vehicle.setManufacture(manufacturer);
		return vehicle;
		
		
	}
}
