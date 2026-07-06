package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.MapUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepository implements IBuildingRepository {
	@Override
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchRequest request) {
		StringBuilder sql = new StringBuilder("select b.id, b.name, b.floor_area,\n"
				+ "b.ward, b.street, b.numberofbasement, b.rent,\n"
				+ "b.service_price, b.manager_name, b.manager_phone_number, b.brokerage_fees\n"
				+ "from building b ");
		handleJoinTable(request, sql);
		Map<String, Object> mapRequest = MapUtil.toMap(request);

		StringBuilder where = new StringBuilder("where 1 = 1 ");
		queryNormal(mapRequest, where);
		querySpecial(mapRequest, where);
		
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
	
	
	public void handleJoinTable(BuildingSearchRequest request, StringBuilder sql) {
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
	
	public void queryNormal(Map<String, Object> request, StringBuilder where) {
		for(Map.Entry<String, Object> it : request.entrySet()) {
			if(!it.getKey().equals("staffId") && !it.getKey().equals("buildingTypes")
				&& !it.getKey().startsWith("area") && !it.getKey().startsWith("rent")
				&& it.getValue() != null) {
				String value = it.getValue().toString();
				if(StringUtil.stringValid(value)) {
					if(NumberUtil.isNumber(value)) {
						where.append(" AND b." + it.getKey() + " = " + value + "\n" );
					} else {
						where.append(" AND b." + it.getKey() + " like '%" + value + "%'\n");
					}
				}
			}
		}
	}
	
	public void querySpecial(Map<String, Object> request, StringBuilder where) {
		String staffId = (String)request.get("staffId");
		if(StringUtil.stringValid(staffId)) {
			where.append("AND ab.staffid = " + staffId + "\n");
		}
		
		String rentAreaFrom = request.get("areaFrom") != null 
				? request.get("areaFrom").toString() : null;
		String rentAreaTo = request.get("areaTo") != null 
				? request.get("areaTo").toString() : null;
		if(StringUtil.stringValid(rentAreaFrom) || StringUtil.stringValid(rentAreaTo)) {
			if(StringUtil.stringValid(rentAreaFrom) && StringUtil.stringValid(rentAreaTo)) {
				where.append("AND b.rent >= " + rentAreaFrom
						+ " AND b.rent <= " + rentAreaTo + "\n");
			}
			else if(StringUtil.stringValid(rentAreaFrom)) {
				where.append("AND b.rent >= " + rentAreaFrom + "\n");
			}
			else where.append("AND b.rent <= " + rentAreaTo + "\n");
		}
		
		String rentPriceFrom = request.get("rentPriceFrom") != null 
				? request.get("rentPriceFrom").toString() : null;
		String rentPriceTo = request.get("rentPriceTo") != null 
				? request.get("rentPriceTo").toString() : null;
		if(StringUtil.stringValid(rentPriceFrom) || StringUtil.stringValid(rentPriceTo)) {
			if(StringUtil.stringValid(rentPriceFrom) && StringUtil.stringValid(rentPriceTo)) {
				where.append("AND b.rent >= " + rentPriceFrom
						+ " AND b.rent <= " + rentPriceTo + " ");
			}
			else if(rentAreaFrom != null) {
				where.append("AND b.rent >= " + rentPriceFrom + " ");
			}
			else where.append("AND b.rent <= " + rentPriceTo + " ");
		}
		
		// java 7
//		@SuppressWarnings("unchecked") // Anotation thong bao compiler khong can canh bao warning nua
//		List<String> types = (List<String>)request.get("buildingTypes");
//		if(StringUtil.stringListValid(types)) {
//			List<String> code = new ArrayList<>();
//			for(String item : types) {
//				code.add("'" + item + "'");
//			}
//			where.append(" AND bt.code IN (" + String.join(",", code) + ")\n");
//		}
		
		// java 8
		@SuppressWarnings("unchecked")
		List<String> types = (List<String>)request.get("buildingTypes");
		if(StringUtil.stringListValid(types)) {
			where.append(" AND (");
			String whereSql = types.stream().map(it ->
			"renttype.code like " + "'%" +it + "%'").collect(Collectors.joining(" OR "));
			where.append(whereSql);
			where.append(")\n");
		}
	}
}