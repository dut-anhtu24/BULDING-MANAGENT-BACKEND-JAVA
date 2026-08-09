package com.javaweb.repository.imp;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
@Primary
public class BuildingRepository implements IBuildingRepository {
	// Các method ứng dụng của EntityManager tương tác với db
	// persist: Dùng để create / insert record
	// merge: Update record
	// remove: Xóa record theo id
	// find: Tìm kiếm record theo id
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchBuilder request) {
		StringBuilder sql = new StringBuilder("select b.* from building b ");
		handleJoinTable(request, sql);

		StringBuilder where = new StringBuilder("where 1 = 1 ");
		queryNormal(request, where);
		querySpecial(request, where);
		
		sql.append(where);
		sql.append("GROUP BY b.id\n");
		System.out.println(sql);
		
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
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
				where.append("AND b.rent_price >= " + rentPriceFrom
						+ " AND b.rent_price <= " + rentPriceTo + "\n");
			}
			else if(rentPriceFrom != null) {
				where.append("AND b.rent_price >= " + rentPriceFrom + "\n");
			}
			else where.append("AND b.rent_price <= " + rentPriceTo + "\n");
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
