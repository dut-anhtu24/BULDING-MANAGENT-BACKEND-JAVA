package com.javaweb.repository.imp;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepository implements IBuildingRepository {
	@Override
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchBuilder request) {
		StringBuilder sql = new StringBuilder("select b.id, b.name, b.floor_area,\n"
				+ "b.ward, b.street, b.numberofbasement, b.rent,\n"
				+ "b.service_price, b.manager_name, b.manager_phone_number, b.brokerage_fees\n"
				+ "from building b ");
		handleJoinTable(request, sql);

		StringBuilder where = new StringBuilder("where 1 = 1 ");
		queryNormal(request, where);
		querySpecial(request, where);
		
		sql.append(where);
		sql.append("GROUP BY b.id\n");
		System.out.println(sql);
		
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection cnn = ConnectionJDBCUtil.getConnection();
			Statement stmt = cnn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString())) {
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setWard(rs.getString("ward"));
				building.setStreet(rs.getString("street"));
				building.setFloorArea(rs.getDouble("floor_area"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setRent(rs.getBigDecimal("rent"));
				building.setServicePrice(rs.getBigDecimal("service_price"));
				building.setManagerName(rs.getString("manager_name"));
				building.setManagerPhoneNumber(rs.getString("manager_phone_number"));
				building.setBrokerageFees(rs.getBigDecimal("brokerage_fees"));
				
				result.add(building);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Connect to databse failed in Buidlings Field");
		}
		return result;
	}

	@Override
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void handleJoinTable(BuildingSearchBuilder request, StringBuilder sql) {
		sql.append("left join district d on b.districtid = d.id\n");
		
		List<String> types = request.getBuildingTypes();
		if(StringUtil.stringListValid(types)) // Kiem tra list ko co phan tu rong
		{
			sql.append("left join building_buildingtype bbt on b.id = bbt.buildingid\n"
					+ "left join buildingtype bt on bbt.buildingtypeid = bt.id\n");
		}
		
		if(NumberUtil.allNotNull(request.getStaffId())) {
			sql.append("left join assignmentbuilding ab on ab.buildingid = b.id\n"
					+ "join user u on u.id = ab.staffid\n");
		}
		
		if(NumberUtil.anyNotNull(request.getAreaFrom(), request.getAreaTo())) {
			sql.append("join rentarea ra on ra.buildingid = b.id\n");
		}
	}
	
	public void queryNormal(BuildingSearchBuilder request, StringBuilder where) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if(!fieldName.equals("staffId") && !fieldName.equals("buildingTypes")
						&& !fieldName.startsWith("area") && !fieldName.startsWith("rent")
						&& item.get(request) != null) {
					String value = item.get(request).toString();
					if(StringUtil.stringValid(value)) {
						if(NumberUtil.isNumber(value)) {
							where.append(" AND b." + fieldName + " = " + value + "\n" );
						} else {
							where.append(" AND b." + fieldName + " like '%" + value + "%'\n");
						}
					}
				}
			}
			
			System.out.println(where);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void querySpecial(BuildingSearchBuilder request, StringBuilder where) {
		Long staffId = request.getStaffId();
		if(staffId != null) {
			where.append("AND ab.staffid = " + staffId + "\n");
		}
		
		Integer rentAreaFrom = request.getAreaFrom() != null 
				? request.getAreaFrom() : null;
		Integer rentAreaTo = request.getAreaTo() != null 
				? request.getAreaTo() : null;
		if(rentAreaFrom != null || rentAreaTo != null) {
			if(rentAreaFrom != null && rentAreaTo != null) {
				where.append("AND ra.areavalue >= " + rentAreaFrom
						+ " AND ra.areavalue <= " + rentAreaTo + "\n");
			}
			else if(rentAreaFrom != null) {
				where.append("AND ra.areavalue >= " + rentAreaFrom + "\n");
			}
			else where.append("AND ra.areavalue <= " + rentAreaTo + "\n");
		}
		
		BigDecimal rentPriceFrom = request.getRentPriceFrom() != null 
				? request.getRentPriceFrom() : null;
		BigDecimal rentPriceTo = request.getRentPriceTo() != null 
				? request.getRentPriceTo() : null;
		if(rentPriceFrom != null || rentPriceTo != null) {
			if(rentPriceFrom != null && rentPriceTo != null) {
				where.append("AND b.rent >= " + rentPriceFrom
						+ " AND b.rent <= " + rentPriceTo + "\n");
			}
			else if(rentPriceFrom != null) {
				where.append("AND b.rent >= " + rentPriceFrom + "\n");
			}
			else where.append("AND b.rent <= " + rentPriceTo + "\n");
		}
		
		// java 8
		List<String> types = request.getBuildingTypes();
		if(StringUtil.stringListValid(types)) {
			where.append(" AND (");
			String whereSql = types.stream().map(it ->
			"renttype.code like " + "'%" +it + "%'").collect(Collectors.joining(" OR "));
			where.append(whereSql);
			where.append(")\n");
		}
	}

}