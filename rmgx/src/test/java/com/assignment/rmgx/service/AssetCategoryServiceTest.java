package com.assignment.rmgx.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.rmgx.exception.ResourceNotFoundException;
import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.repository.AssetCategoryRepository;

@ExtendWith(MockitoExtension.class)
class AssetCategoryServiceTest {

	AssetCategoryService acService;

	@Mock
	AssetCategoryRepository acRepository;

	@BeforeEach
	public void setUp() {
		acService = new AssetCategoryService(acRepository);
	}

	@Test
	void testGetCategories() {

		AssetCategory ac = new AssetCategory();
		
		List<AssetCategory> acl = new ArrayList<>();
		acl.add(ac);

		when(acRepository.findAll()).thenReturn(acl);

		List<AssetCategory> acList = acService.getCategories();
		assertEquals(1, acList.size());

		verify(acRepository, times(1)).findAll();

	}

	@Test
	void testGetCategoryById() {
		AssetCategory ac = new AssetCategory();
		ac.setId(1L);
		ac.setName("Chair");

		when(acRepository.findById(1L)).thenReturn(Optional.of(ac));

		AssetCategory acTest = acService.getCategoryById(1L);
		assertEquals(ac.getId(), acTest.getId());
		assertEquals(ac.getName(),acTest.getName());

		verify(acRepository, times(1)).findById(1L);

	}

	@Test
	@DisplayName("Testing Resource Not Found Exception Of getCategoryById()")
	void testGetCategoryByIdException() {
		ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
				() -> acService.getCategoryById((long) 1));
		assertTrue(exception.getMessage().contains("Asset Category Not Found With ID : 1"));
	}

	@Test
	void testGetCategoryByName() {
		AssetCategory ac = new AssetCategory();

		when(acRepository.findByName("chair")).thenReturn(Optional.of(ac));

		AssetCategory acTest = acService.getCategoryByName("chair");
		assertEquals(ac, acTest);

		verify(acRepository, times(1)).findByName("chair");
	}

	@Test
	void testAddCategory() {
		AssetCategory ac = new AssetCategory();

		when(acRepository.save(ac)).thenReturn(ac);

		AssetCategory acTest = acService.addCategory(ac);
		assertEquals(ac, acTest);

		verify(acRepository, times(1)).save(ac);

	}

}
