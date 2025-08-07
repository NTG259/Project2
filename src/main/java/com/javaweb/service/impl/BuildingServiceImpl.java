package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;


//take data from BuildingRepo and transfer to suitable for front-end
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired // need because interface has not constructor. So need @Autowired to declare interface
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAll(String name, Long districtId, List<String> typeCode) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, districtId, typeCode);
		List<BuildingDTO> result = new ArrayList<>();
		
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setNumberOfBasement(item.getNumberOfBasement());;
			building.setAddress(item.getStreet() + ", " + item.getWard());
			result.add(building);
		}
		
		return result;
	}

	@Override
	public void DeleteById(Integer id) {
		System.out.println("hehe");
		System.out.println("hihi");
		return;
	}

	@Override
	public List<BuildingDTO> findBuildingByArea(Long Area) {
		List<BuildingDTO> buildingDTOs = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findBuildingEntitiesByArea(Area);
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setArea(item.getArea());
			buildingDTOs.add(buildingDTO);
		}
		return buildingDTOs;
	}
}
