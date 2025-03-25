package com.valtech.hackathon.vehicle.services;

import java.util.List;

import com.valtech.hackathon.vehicle.vos.VehicleVO;

public interface VehicleService {

	VehicleVO getVehicleByReferenceId(Long id);

	List<VehicleVO> getAllVehicles();

	VehicleVO saveOrUpdateVehicle(VehicleVO vvo);

}
