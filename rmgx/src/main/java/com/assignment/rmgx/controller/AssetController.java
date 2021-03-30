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

@RestController
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
    Logger logger = LoggerFactory.getLogger(AssetController.class);

	
	@GetMapping("/assets")
	public List<AssetDTO> getAsset() {
		return assetService.getAllAssets();
	}
	
	@GetMapping("/assets/{name}")
	public AssetDTO getAssetByName(@PathVariable String name) {
		return assetService.getAssetByName(name);
	}
	
	@PostMapping("/assets")
	public AssetDTO addAsset(@RequestBody AssetDTO assetDTO) {
		return assetService.addAsset(assetDTO);
	}
	
	@PostMapping("/assign-asset")
	public AssetDTO assignAsset(@RequestBody AssetDTO assetDTO) {
		return assetService.assignAsset(assetDTO);
	}
	
	@PutMapping("/recover-asset/{assetId}")
	public AssetDTO recoverAsset(@RequestBody AssetDTO assetDTO,@PathVariable Long assetId) {
		return assetService.recoverAsset(assetDTO, assetId);
	}
	
	@PutMapping("/assets/{id}")
	public AssetDTO updateAsset(@RequestBody AssetDTO assetDTO, @PathVariable Long id) {
		AssetDTO asset = assetService.updateAsset(assetDTO, id);
		return asset;
	}
	
	@DeleteMapping("/assets/{id}")
	public void deleteAsset(@PathVariable Long id) {
		assetService.deleteAsset(id);
	}
	
}
