package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;
import com.valtech.training.restapis.vos.WatchVO;

public interface OwnerService {
	

	List<OwnerVO> getOwners();

	OwnerVO getOwner(long id);

	OwnerVO UpdateOwner(long id, OwnerVO owner);

	OwnerVO createOwner(OwnerVO owner);

	List<OwnerVO> getOwnersByName(String name);

	OwnerVO addwatchesToOwner(long id, List<Long> watches);


}
