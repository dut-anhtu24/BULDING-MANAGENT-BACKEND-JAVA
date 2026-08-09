package com.javaweb.repository.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
@Primary
public class BuildingRepository implements IBuildingRepository {
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchBuilder request) {
		// TODO Auto-generated method stub
//		// JPQL: JPA Query Language
//		String sql = "FROM BuildingEntity";
//		Query query = entityManager.createQuery(sql, BuildingEntity.class);
	
		// SQL Native
		String sql = "SELECT * FROM buidling";
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
	}

	@Override
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
