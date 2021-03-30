package com.assignment.rmgx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.rmgx.exception.ResourceNotFoundException;
import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.repository.AssetCategoryRepository;

@Service
public class AssetCategoryService {

	@Autowired
	private AssetCategoryRepository assetCategoryRepository;

	public List<AssetCategory> getCategories() {
		return assetCategoryRepository.findAll();
	}

	public AssetCategory getCategoryById(Long id) {
		AssetCategory assetCategory = assetCategoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset Category Not Found With ID : "+id));

		return assetCategory;
	}

	public AssetCategory getCategoryByName(String name) {
		AssetCategory assetCategory = assetCategoryRepository.findByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("Asset Category Not Found With Name : " + name));
		return assetCategory;
	}

	public AssetCategory addCategory(AssetCategory ac) {
		return assetCategoryRepository.save(ac);
	}

	public AssetCategory updateCategory(AssetCategory ac, Long id) {
		AssetCategory assetCategory = getCategoryById(id);
		assetCategory.setName(ac.getName());
		assetCategory.setDescription(ac.getDescription());

		return assetCategoryRepository.save(assetCategory);
	}

}
