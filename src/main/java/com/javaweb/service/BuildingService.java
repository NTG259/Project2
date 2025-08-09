package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.EntitySearchCriteria;
//interface only has 2 things : abstract method
public interface BuildingService {
	//abstract method
	List<BuildingDTO> findBuildings(EntitySearchCriteria entitySearchCriteria);
}
