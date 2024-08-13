package com.java.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.buildingService.BuildingService;
import com.java.model.BuildingDTO;

@RestController
public class BuildingAPI {
	@Autowired 
	private BuildingService buildingService;
	@GetMapping(value="api/test")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> map){
		List<BuildingDTO> result = buildingService.findAll(map);
		return result;
	}
}
