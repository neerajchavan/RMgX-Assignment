package com.assignment.rmgx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.rmgx.model.Asset;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long>{

	public List<Asset> findAll();
	public Optional<Asset> findById(Long id);
	public Optional<Asset> findByName(String name);
}
