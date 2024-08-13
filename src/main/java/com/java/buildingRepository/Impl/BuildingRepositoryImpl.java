package com.java.buildingRepository.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.buildingRepository.BuildingRepository;
import com.java.buildingRepository.Entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String db = "jdbc:mysql://localhost:3306/estatebasic";
	static final String user = "root";
	static final String pass = "root_password";
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> map) {
		List<Object> tmp = new ArrayList<>();
		StringBuilder sb = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if ("buildingName".equals(key)) {
				sb.append(" AND building.name LIKE ?");
				tmp.add("%" + value + "%");
			}
			if ("floorArea".equals(key)) {
				sb.append(" AND floorarea = ?");
				tmp.add(value);
			}
			if ("ward".equals(key)) {
				sb.append(" AND ward LIKE ?");
				tmp.add(value);
			}
			if ("street".equals(key)) {
				sb.append(" AND street LIKE ?");
				tmp.add("%" + value + "%");
			}
			if ("numberOfBasement".equals(key)) {
				sb.append(" AND numberofbasement = ?");
				tmp.add(value);
			}
			if ("direction".equals(key)) {
				sb.append(" AND direction LIKE ?");
				tmp.add(value);
			}
			if ("managerName".equals(key)) {
				sb.append(" AND managername LIKE ?");
				tmp.add("%" + value + "%");
			}
			if ("managerNumberPhone".equals(key)) {
				sb.append(" AND managerphonenumber LIKE ?");
				tmp.add(value);
			}
		}
		List<BuildingEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(db, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sb.toString())) {
			for (int i = 0; i < tmp.size(); i++) {
				stmt.setObject(i + 1, tmp.get(i));
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setBuildingName(rs.getString("building.name"));
				building.setFloorArea(rs.getInt("floorarea"));
				building.setWard(rs.getString("ward"));
				building.setStreet(rs.getString("street"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setDirection(rs.getString("direction"));
				building.setLevel(rs.getString("level"));
				building.setManagerName(rs.getString("managername"));
				building.setManagerNumberPhone(rs.getString("managerphonenumber"));
				result.add(building);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
