package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;


// use to connect to database and query data from database
@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	private static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
    private static final String USER = "root";
    private static final String PASSSWORD = "Truonggiang2912@";
    private static Connection conn;
    
    public void connectDatabase () {
    	try {
    		conn = DriverManager.getConnection(URL, USER, PASSSWORD);
			System.out.println("Access !");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
    }
    
	@Override
	public List<BuildingEntity> findAll(String name, Long districtId, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("select * from building b where 1 = 1");
		
		if (name != null && !name.isEmpty()) {
			sql.append(" and b.name like " + "'%" + name + "%'");
		}
		if (districtId != null) {
			sql.append(" and b.districtid " + " = " + districtId);
		}
		connectDatabase();
		List<BuildingEntity> result = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql.toString());
			while (resultSet.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(resultSet.getString("name"));
				building.setNumberOfBasement(resultSet.getInt("numberofbasement"));
				building.setStreet(resultSet.getString("street"));
				building.setWard(resultSet.getString("ward"));
				result.add(building);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return result;
	}
	
}
