package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.EntitySearchCriteria;

public interface BuildingRepository {
	List<BuildingEntity> findBuildingEntities(EntitySearchCriteria entitySearchCriteria);
}
