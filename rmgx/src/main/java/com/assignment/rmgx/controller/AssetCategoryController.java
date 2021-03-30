package com.assignment.rmgx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.service.AssetCategoryService;

@RestController
public class AssetCategoryController {
	
	@Autowired
	private AssetCategoryService assetCategoryService;
	
    Logger logger = LoggerFactory.getLogger(AssetController.class);
	
	@GetMapping("/asset-category")
	public List<AssetCategory> getAllAssetCategory() {
		return assetCategoryService.getCategories();
	}
	
	@GetMapping("/asset-category/{id}")
	public AssetCategory getAssetCategory(@PathVariable Long id) {
		return assetCategoryService.getCategoryById(id);
	}
	
	@PostMapping("/asset-category")
	public ResponseEntity<AssetCategory> addAssetCategory(@RequestBody AssetCategory ac){
		AssetCategory assetCategory = assetCategoryService.addCategory(ac);
		
		return new ResponseEntity<AssetCategory>(assetCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/asset-category/{id}")
	public ResponseEntity<AssetCategory> updateAssetCategory(@RequestBody AssetCategory ac, @PathVariable Long id){
		AssetCategory assetCategory = assetCategoryService.updateCategory(ac, id);
		return new ResponseEntity<AssetCategory>(assetCategory, HttpStatus.OK);
	}

}
