package com.valtech.hackathon.vehicle.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.hackathon.vehicle.entities.Vehicle;
import com.valtech.hackathon.vehicle.repos.VehicleRepo;
import com.valtech.hackathon.vehicle.vos.VehicleVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepo vehicleRepo;
	

	@Override
	public VehicleVO getVehicleByReferenceId(Long id) {
		return VehicleVO.from(vehicleRepo.getReferenceById(id));
	}
	

	@Override
	public List<VehicleVO> getAllVehicles(){
		return vehicleRepo.findAll().stream().map(l->VehicleVO.from(l)).collect(Collectors.toList());
	}
	
	@Override
	public VehicleVO saveOrUpdateVehicle(VehicleVO vvo) {
		Vehicle v= vvo.to();
		v= vehicleRepo.save(v);
		return VehicleVO.from(v);
		
	}
	
	
}