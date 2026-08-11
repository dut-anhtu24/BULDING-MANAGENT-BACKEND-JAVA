package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.custom.IBuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;

//public interface IBuildingRepository extends JpaRepository<BuildingEntity, Long>, IBuildingRepositoryCustom {
public interface IBuildingRepository {
	public List<BuildingEntity> getBuildingsByRequest(BuildingSearchBuilder request);
//	List<BuildingEntity> findByNameContanining(String s);
//	List<BuildingEntity> findAll();
}
