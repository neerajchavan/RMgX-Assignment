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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class AssetCategoryController {
	
	@Autowired
	private AssetCategoryService assetCategoryService;
	
    Logger logger = LoggerFactory.getLogger(AssetController.class);
	
	@GetMapping("/asset-category")
	@ApiOperation(
			value = "Get Asset Category List",
			response = AssetCategory.class
	)
	public List<AssetCategory> getAllAssetCategory() {
		return assetCategoryService.getCategories();
	}
	
	@GetMapping("/asset-category/{id}")
	@ApiOperation(
			value = "Get Asset Category By ID",
			notes = "Provide an ID to get specific Asset Category",
			response = AssetCategory.class
	)
	public AssetCategory getAssetCategory(@PathVariable Long id) {
		return assetCategoryService.getCategoryById(id);
	}
	
	
	@PostMapping("/asset-category")
	@ApiOperation(
			value = "Add Asset Category",
			response = AssetCategory.class
	)
	public ResponseEntity<AssetCategory> addAssetCategory(@ApiParam(value = "No need to include ID in body", required = true) @RequestBody AssetCategory assetCategory){
		AssetCategory ac = assetCategoryService.addCategory(assetCategory);
		
		return new ResponseEntity<AssetCategory>(ac, HttpStatus.CREATED);
	}
	
	@PutMapping("/asset-category/{id}")
	@ApiOperation(
			value = "Update Asset Category",
			notes = "Provide an ID  Asset-Category",
			response = AssetCategory.class
	)
	public ResponseEntity<AssetCategory> updateAssetCategory(@RequestBody AssetCategory assetCategory, @ApiParam(value = "ID value of an Asset Category that you want to update", required = true) @PathVariable Long id){
		AssetCategory ac = assetCategoryService.updateCategory(assetCategory, id);
		return new ResponseEntity<AssetCategory>(ac, HttpStatus.OK);
	}

}
