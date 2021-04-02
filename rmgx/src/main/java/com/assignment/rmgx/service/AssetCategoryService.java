package com.assignment.rmgx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.rmgx.exception.ResourceNotFoundException;
import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.repository.AssetCategoryRepository;

@Service
public class AssetCategoryService {

	private AssetCategoryRepository acRepository;

	@Autowired
	public AssetCategoryService(AssetCategoryRepository acRepository) {
		this.acRepository = acRepository;
	}

	public List<AssetCategory> getCategories() {
		return acRepository.findAll();
	}

	public AssetCategory getCategoryById(Long id) {
		AssetCategory assetCategory = acRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset Category Not Found With ID : "+id));

		return assetCategory;
	}

	public AssetCategory getCategoryByName(String name) {
		AssetCategory assetCategory = acRepository.findByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("Asset Category Not Found With Name : " + name));
		return assetCategory;
	}

	public AssetCategory addCategory(AssetCategory ac) {
		return acRepository.save(ac);
	}

	public AssetCategory updateCategory(AssetCategory ac, Long id) {
		AssetCategory assetCategory = getCategoryById(id);
		assetCategory.setName(ac.getName());
		assetCategory.setDescription(ac.getDescription());

		return acRepository.save(assetCategory);
	}

}
