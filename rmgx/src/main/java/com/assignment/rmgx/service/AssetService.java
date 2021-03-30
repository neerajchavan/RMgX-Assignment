package com.assignment.rmgx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.rmgx.dto.AssetDTO;
import com.assignment.rmgx.exception.ResouceAssignedException;
import com.assignment.rmgx.exception.ResourceNotFoundException;
import com.assignment.rmgx.model.Asset;
import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.model.Employee;
import com.assignment.rmgx.repository.AssetRepository;
import com.assignment.rmgx.repository.EmployeeRepository;

@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AssetCategoryService assetCategoryService;

	public List<AssetDTO> getAllAssets() {

		List<Asset> assetList = assetRepository.findAll();
		List<AssetDTO> assetDtoList = new ArrayList<>();

		for (Asset asset : assetList) {
			AssetDTO dto = new AssetDTO(asset);
			assetDtoList.add(dto);
		}

		return assetDtoList;
	}

	public AssetDTO getAssetByName(String name) {
		Asset asset = assetRepository.findByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot Find Asset With Name : " + name));
		return new AssetDTO(asset);
	}

	public AssetDTO addAsset(AssetDTO assetDTO) {
		AssetCategory ac = assetCategoryService.getCategoryByName(assetDTO.getCategory());
		Asset asset = new Asset();
		asset.setCategory(ac);
		asset.setName(assetDTO.getName());
		asset.setCondition(assetDTO.getCondition());
		asset.setPurchaseDate(assetDTO.getPurchaseDate());
		asset.setStatus(assetDTO.getStatus());
		asset.setPurchaseDate(assetDTO.getPurchaseDate());

		asset = assetRepository.save(asset);

		return new AssetDTO(asset);

	}

	public AssetDTO updateAsset(AssetDTO assetDTO, Long id) {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset Not Found With ID : " + id));
		AssetCategory ac = assetCategoryService.getCategoryByName(assetDTO.getCategory());

		asset.setCategory(ac);
		asset.setName(assetDTO.getName());
		asset.setCondition(assetDTO.getCondition());
		asset.setPurchaseDate(assetDTO.getPurchaseDate());
		asset.setStatus(assetDTO.getStatus());
		asset = assetRepository.save(asset);

		return new AssetDTO(asset);
	}

	public void deleteAsset(Long id) {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset Not Found With ID : " + id));

		if (asset.getStatus().equals("Assigned"))
			throw new ResouceAssignedException("Asset Is Assigned To Some Employee, So It Cannot Be Deleted");
		else
			assetRepository.deleteById(asset.getId());
	}

	public AssetDTO assignAsset(AssetDTO assetDTO) {
		Asset asset = assetRepository.findById(assetDTO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot Find Asset With Id : " + assetDTO.getId()));

		if (!asset.getStatus().equalsIgnoreCase("Assigned")) {
			Employee employee = employeeRepository.findById(assetDTO.getAssignedTo()).orElseThrow(
					() -> new ResourceNotFoundException("Employee Not Found With ID : " + assetDTO.getAssignedTo()));

			asset.setStatus("Assigned");
			asset.setEmployee(employee);
			asset = assetRepository.save(asset);

			AssetDTO dto = new AssetDTO(asset);
			dto.setAssignedTo(asset.getEmployee().getId());

			return dto;
		} else
			throw new ResouceAssignedException("Asset Already Assigned To Some Other Employee");
	}

	public AssetDTO recoverAsset(AssetDTO assetDTO, Long assetId) {
		Asset asset = assetRepository.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot Find Asset With ID : " + assetId));

		if (asset.getStatus().equalsIgnoreCase("Assigned")) {

			asset.setCondition(assetDTO.getCondition());
			asset.setStatus("Recovered");
			asset.setEmployee(null);
			asset = assetRepository.save(asset);

			return new AssetDTO(asset);
		} else
			throw new ResouceAssignedException("Asset You Are Trying To Recover, Has Status Available/Recovered");
	}
}
