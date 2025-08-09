package com.javaweb.service.impl;

import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.EntitySearchCriteria;
import com.javaweb.service.BuildingService;


//take data from BuildingRepo and transfer to suitable for front-end
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired // need because interface has not constructor. So need @Autowired to declare interface
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findBuildings(EntitySearchCriteria entitySearchCriteria) {
		List<BuildingDTO> result = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findBuildingEntities(entitySearchCriteria);
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setAddress(item.getStreet() + ", " + item.getDistrict() + ", " + item.getWard());
			buildingDTO.setNameManager(item.getManagerName());
			buildingDTO.setNumberPhoneManager(item.getManagerphonenumber());
			buildingDTO.setAreaFloor("" + item.getFloorarea() + "m2");
			buildingDTO.setAreaRent("" + item.getRentArea() + "m2");
			buildingDTO.setBrokerageFee(item.getBrokeragefee() + "đ");
			buildingDTO.setPriceRent(item.getRentpricedescription());
			buildingDTO.setServiceFee("" + item.getServicefee() + "đ");
			result.add(buildingDTO);
		}
		return result;
	}
}
