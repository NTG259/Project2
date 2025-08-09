package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.EntitySearchCriteria;
import com.mysql.cj.util.EscapeTokenizer;


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
	public List<BuildingEntity> findBuildingEntities(EntitySearchCriteria entitySearchCriteria) {
		List<BuildingEntity> buildingEntities = new ArrayList<>();
		connectDatabase();
		StringBuilder sql = new StringBuilder();
		sql.append("select ")
			
			.append("building.id as id, ")
		  .append("building.name as buildingName, ")
		  .append("building.districtid as districtId, ")
		  .append("district.name as district, ")
		  .append("building.ward as ward, ")
		  .append("building.street as street, ")
		  .append("building.direction as direction, ")
		  .append("building.numberofbasement as numberofbasement, ")
		  .append("building.floorarea as floorarea, ")
		  .append("rentarea.value as rentarea, ")
		  .append("building.rentprice as rentprice, ")
		  .append("building.rentpricedescription as rentpricedescription, ")
		  .append("building.servicefee as servicefee, ")
		  .append("building.brokeragefee as brokeragefee, ")
		  .append("building.level as level, ")
		  .append("assignmentbuilding.staffid as staffId, ")
		  .append("building.managername as managername, ")
		  .append("building.managerphonenumber as managerphonenumber, ")
		  .append("renttype.name as renttype ")
		  .append("from building ")
		  .append("join district on building.districtid = district.id ")
		  .append("join buildingrenttype on building.id = buildingrenttype.buildingid ")
		  .append("join renttype on buildingrenttype.renttypeid = renttype.id ")
		  .append("join rentarea on building.id = rentarea.buildingid ")
		  .append("join assignmentbuilding on building.id = assignmentbuilding.id ")
		  .append("join user on user.id = assignmentbuilding.staffid");
		Set<Integer> buildingsSet = new LinkedHashSet<>();
		sql.append(" where 1 = 1 \n");
		if (entitySearchCriteria.getName() != null && !entitySearchCriteria.equals("") ) {
			sql.append("and building.name like '%" + entitySearchCriteria.getName() + "%'\n");
		}
		
		if (entitySearchCriteria.getIdDistrict() != null) {
			sql.append("and building.districtid = " + entitySearchCriteria.getIdDistrict() + "\n");
		}
		
		if (entitySearchCriteria.getIdResponsibleStaff() != null) {
			sql.append("and assignmentbuilding.staffid = " + entitySearchCriteria.getIdResponsibleStaff() + "\n");
		}
		
		if (entitySearchCriteria.getWard() != null && !entitySearchCriteria.getWard().equals("")) {
			sql.append("and building.ward = " + entitySearchCriteria.getWard() + "\n");
		}
		
		if (entitySearchCriteria.getNumberOfBasement() != null) {
			sql.append("and building.numberofbasement = " + entitySearchCriteria.getNumberOfBasement() + "\n");
		}
		
		if (entitySearchCriteria.getArea() != null) {
			sql.append("and rentarea.value = " + entitySearchCriteria.getArea() + "\n");
		}
		
		if (entitySearchCriteria.getMinArea() != null) {
			sql.append("and rentarea.value >= " + entitySearchCriteria.getMinArea() + "\n");
		}
		
		if (entitySearchCriteria.getMaxArea() != null) {
			sql.append("and rentarea.value <= " + entitySearchCriteria.getMaxArea() + "\n");
		}
		
		if (entitySearchCriteria.getMinRentPrice() != null) {
			sql.append("and building.renprice >= " + entitySearchCriteria.getMinRentPrice() + "\n");
		}
		
		if (entitySearchCriteria.getMaxRentPrice() != null) {
			sql.append("and building.renprice <= " + entitySearchCriteria.getMaxRentPrice() + "\n");
		}
		
		if (entitySearchCriteria.getManagerName() != null && !entitySearchCriteria.getManagerName().equals("")) {
			sql.append("and building.managername like '%" + entitySearchCriteria.getManagerName() + "%'\n");
		}
		
		if (entitySearchCriteria.getManagerPhoneNumber() != null && !entitySearchCriteria.getManagerPhoneNumber().equals("")) {
			sql.append("and building.managerphonenumber like '%" + entitySearchCriteria.getManagerPhoneNumber() + "%'\n");
		}
		
		if (entitySearchCriteria.getDirection() != null && !entitySearchCriteria.getDirection().equals("")) {
			sql.append("and building.direction = " + entitySearchCriteria.getDirection() + "\n");
		}
		
		if (entitySearchCriteria.getStreet() != null && !entitySearchCriteria.getStreet().equals("")) {
			sql.append("and building.street like '%" + entitySearchCriteria.getStreet() + "%'\n");
		}
		
		if (entitySearchCriteria.getRank() != null){
			sql.append("and building.level = " + entitySearchCriteria.getRank() + "\n");
		}
		
		if (entitySearchCriteria.getTypeBuilding() != null && !entitySearchCriteria.getTypeBuilding().equals("")) {
			sql.append("and building.structure like '%" + entitySearchCriteria.getTypeBuilding() + "%'\n");
		}
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql.toString());
			while (rs.next()) {
				BuildingEntity item = new BuildingEntity();
				item.setName(rs.getString("buildingName"));
				item.setStreet(rs.getString("street"));
				item.setWard(rs.getString("ward"));
				item.setDistrict(rs.getString("district"));
				item.setNumberofbasement(rs.getInt("numberofbasement"));
				item.setFloorarea(rs.getInt("floorarea"));
				item.setDirection(rs.getString("direction"));
				item.setRentprice(rs.getInt("rentprice"));
				item.setRentpricedescription(rs.getString("rentpricedescription"));
				item.setServicefee(rs.getLong("servicefee"));
				item.setBrokeragefee(rs.getLong("brokeragefee"));
				item.setRentArea(rs.getLong("rentarea"));
				item.setManagerName(rs.getString("managername"));
				item.setManagerphonenumber(rs.getString("managerphonenumber"));
				
				buildingEntities.add(item);
				buildingsSet.add(rs.getInt("id"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return buildingEntities;
	}
    
	
}
