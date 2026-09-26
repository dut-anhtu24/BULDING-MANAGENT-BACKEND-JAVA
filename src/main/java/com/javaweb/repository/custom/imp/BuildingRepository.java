package com.javaweb.repository.custom.imp;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.custom.IBuildingRepositoryCustom;
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
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select b from BuildingEntity b ");
		handleJoinTable(request, sql);
		sql.append("WHERE 1 = 1 ");
		
		Map<String, Object> parameters = new HashMap<>();
		queryNormal(request, sql, parameters);
		querySpecial(request, sql, parameters);
		
		TypedQuery<BuildingEntity> query = entityManager.createQuery(sql.toString(), BuildingEntity.class);
		parameters.forEach(query::setParameter);
		
		return query.getResultList();
	}
	
	public void handleJoinTable(BuildingSearchBuilder request, StringBuilder sql) {
		sql.append("left join b.district d\n");
		List<String> types = request.getBuildingTypes();
		if(StringUtil.stringListValid(types)) // Kiem tra list ko co phan tu rong
		{
			sql.append("left join b.buildingTypes bt\n");
		}
		
		if(NumberUtil.allNotNull(request.getStaffId())) {
			sql.append("left join b.users u\n");
		}
		
		if(NumberUtil.anyNotNull(request.getAreaFrom(), request.getAreaTo())) {
			sql.append("join b.rentAreas ra\n");
		}
	}
	
	public void queryNormal(BuildingSearchBuilder request, 
						StringBuilder where, Map<String, Object> parameters) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if(!fieldName.equals("staffId") && !fieldName.equals("buildingTypes")
						&& !fieldName.startsWith("area") && !fieldName.startsWith("rent")
						&& item.get(request) != null) {
					Object value = item.get(request);
					if(StringUtil.stringValid(value.toString())) {
						System.out.println("fieldName = " + fieldName);
						System.out.println("value = " + value);
						System.out.println("value class = " + value.getClass());
						System.out.println("isNumber = " + NumberUtil.isNumber(value));
						if(NumberUtil.isNumber(value)) {
							where.append(" AND b." + fieldName + " = :" + fieldName + "\n" );
							parameters.put(fieldName, value);
						} else {
							where.append(" AND b." + fieldName + " like :" + fieldName + "\n");
							parameters.put(fieldName, "%" + value + "%");
						}
					}
				}
			}
			
			System.out.println(where);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void querySpecial(BuildingSearchBuilder request,
						StringBuilder where, Map<String, Object> parameters) {
		// Handle Staff
		if(request.getStaffId() != null) {
			where.append("AND u.id = :id\n");
			parameters.put("id", request.getStaffId());
		}
		
		// Handle rent area
		if(request.getAreaFrom() != null) {
			where.append("AND ra.areaValue >= :areaFrom\n");
			parameters.put("areaFrom", request.getAreaFrom());
		}
		
		if(request.getAreaTo() != null) {
			where.append("AND ra.areaValue <= :areaTo\n");
			parameters.put("areaTo", request.getAreaTo());
		}
		
		// Handle rent price
		if(request.getRentPriceFrom() != null) {
			where.append("AND b.rentPrice >= :rentPriceFrom\n");
			parameters.put("rentPriceFrom", request.getRentPriceFrom());
		}
		
		if(request.getRentPriceTo() != null) {
			where.append("AND b.rentPrice <= :rentPriceTo\n");
			parameters.put("rentPriceTo", request.getRentPriceTo());
		}
		
		// Handle types
		// java 8
		List<String> types = request.getBuildingTypes();
		if (StringUtil.stringListValid(types)) {
			where.append("AND bt.code IN :buildingTypes\n");
			parameters.put("buildingTypes", types);
		}
	}
	
}
