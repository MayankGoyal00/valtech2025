package com.valtech.training.restapis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.repos.OwnerRepo;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.OwnerVO;

@Service
@Transactional(propagation =Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private WatchRepo watchRepo;
	/*
	 * from OwnerVO get the Owner
	 * create Owner on DB
	 * create OwnerVO from Owner
	 * return OwnerVO.
	 * */
	
	@Override
	public OwnerVO createOwner(OwnerVO ownerVO) {
		Owner owner = ownerVO.toOwner();
		owner =ownerRepo.save(owner);
		return OwnerVO.from(owner);
		
	}
	
	
	/*
	 * from OwnerVO get the Owner
	 * Update Owner on DB
	 * return Owner.
	 * */
	
	
	@Override
	public OwnerVO UpdateOwner(long id, OwnerVO ownerVO) {
		Owner owner = ownerRepo.getReferenceById(id);
		ownerVO.updateOwnerFromVO(owner); 
		return OwnerVO.from(ownerRepo.save(owner));
	}
	
	
	@Override
	public OwnerVO getOwner(long id) {
		Owner owner= ownerRepo.getReferenceById(id);
		return OwnerVO.from(owner);
		
	}

	@Override
	public List<OwnerVO> getOwners() {
		return OwnerVO.toOwnerVO(ownerRepo.findAll());
	}


	@Override
	public List<OwnerVO> getOwnersByName(String name) {
		return OwnerVO.toOwnerVO(ownerRepo.findAllByName(name));
	}


	@Override
	public OwnerVO addwatchesToOwner(long id, List<Long> watches) {
		final Owner owner = ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid->owner.addWatch(watchRepo.getReferenceById(wid)));
		Owner owner1=ownerRepo.save(owner);
		return OwnerVO.from(owner1);
	}
	
	

}

