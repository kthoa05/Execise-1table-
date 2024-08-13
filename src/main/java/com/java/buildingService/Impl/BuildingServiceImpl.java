package com.java.buildingService.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.buildingRepository.BuildingRepository;
import com.java.buildingRepository.Entity.BuildingEntity;
import com.java.buildingService.BuildingService;
import com.java.model.BuildingDTO;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingDTO> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(map);
		List<BuildingDTO> result = new ArrayList<>();
		for (BuildingEntity x : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setBuildingName(x.getBuildingName());
			building.setAddress(x.getStreet() + ", " + x.getWard());
			building.setNumberOfBasement(x.getNumberOfBasement());
			building.setManagerName(x.getManagerName());
			building.setManagerNumberPhone(x.getManagerNumberPhone());
			building.setFloorArea(x.getFloorArea());
			result.add(building);
		}
		return result;
	}

}
