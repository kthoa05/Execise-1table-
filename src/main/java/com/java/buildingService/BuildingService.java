package com.java.buildingService;

import java.util.List;
import java.util.Map;

import com.java.model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(Map<String, Object> map);
}
