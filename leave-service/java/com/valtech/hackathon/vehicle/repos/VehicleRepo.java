package com.valtech.hackathon.vehicle.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.hackathon.vehicle.entities.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{

}
