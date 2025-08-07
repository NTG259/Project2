package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(String name, Long districtId, List<String> typeCode);
	List<BuildingEntity> findBuildingEntitiesByArea(Long Area);
}
