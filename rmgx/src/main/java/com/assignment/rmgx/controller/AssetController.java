package com.assignment.rmgx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rmgx.dto.AssetDTO;
import com.assignment.rmgx.model.Asset;
import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.model.Employee;
import com.assignment.rmgx.service.AssetService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class AssetController {

	@Autowired
	private AssetService assetService;

	@GetMapping("/assets")
	@ApiOperation(value = "Get All Assets", response = AssetDTO.class)
	public List<AssetDTO> getAsset() {
		return assetService.getAllAssets();
	}

	@PostMapping("/assets")
	@ApiOperation(value = "Add Asset", response = AssetDTO.class)
	public AssetDTO addAsset(
			@ApiParam(value = "No need to include ID in body", required = true) @RequestBody AssetDTO asset) {
		return assetService.addAsset(asset);
	}

	@PostMapping("/assign-asset")
	@ApiOperation(value = "Assign Asset to Employee", response = AssetDTO.class)
	public AssetDTO assignAsset(
			@ApiParam(value = "Requires id & assignedTo attributes of Asset Object. (assignedTo = ID of the Employee to which you want to assign the Asset). No need to set other properties", required = true) @RequestBody AssetDTO asset) {
		return assetService.assignAsset(asset);
	}

	@PutMapping("/recover-asset/{assetId}")
	@ApiOperation(value = "Recover Asset from Employee", response = AssetDTO.class)
	public AssetDTO recoverAsset(
			@ApiParam(value = "Requires Asset ID which you want to recover. Asset body is required to update condition of Asset. Please set 'condition' attribute of Asset. No need to set other attributes.") @RequestBody AssetDTO asset,
			@PathVariable Long assetId) {
		return assetService.recoverAsset(asset, assetId);
	}

	@PutMapping("/assets/{id}")
	@ApiOperation(value = "Update Asset", response = AssetDTO.class)
	public AssetDTO updateAsset(@ApiParam(value = "Requires Asset Body & Asset ID") @RequestBody AssetDTO asset,
			@PathVariable Long id) {
		AssetDTO updatedAsset = assetService.updateAsset(asset, id);
		return updatedAsset;
	}

	@GetMapping("/assets/{name}")
	@ApiOperation(value = "Search Asset By Name", response = AssetDTO.class)
	public AssetDTO getAssetByName(
			@ApiParam(value = "Search operation is case sensitive. Please mention exact asset name") @PathVariable String name) {
		return assetService.getAssetByName(name);
	}

	@DeleteMapping("/assets/{id}")
	@ApiOperation(value = "Delete Asset By ID", response = AssetDTO.class)
	public void deleteAsset(
			@ApiParam(value = "Requires ID of the Asset which you want to delete. Asset already assigned to other Employee cannot be deleted") @PathVariable Long id) {
		assetService.deleteAsset(id);
	}

}
