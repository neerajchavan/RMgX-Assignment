package com.assignment.rmgx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.rmgx.model.AssetCategory;

@Repository
public interface AssetCategoryRepository extends CrudRepository<AssetCategory, Long>{

	public List<AssetCategory> findAll();
	public Optional<AssetCategory> findById(Long id);
	public Optional<AssetCategory> findByName(String categoryName);

}
