package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;
//interface only has 2 things : abstract method
public interface BuildingService {
	//abstract method
	List<BuildingDTO> findAll(String name, Long districtId, List<String> typeCode);
	List<BuildingDTO> findBuildingByArea(Long Area);
	void DeleteById(Integer id);
}
