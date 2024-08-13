package com.java.buildingRepository;

import java.util.List;
import java.util.Map;

import com.java.buildingRepository.Entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll (Map<String, Object> map);
}
