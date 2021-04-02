package com.assignment.rmgx.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssetCategoryTest {
	
	AssetCategory assetCategory;
	
	@BeforeEach
	public void setUp() {
		assetCategory = new AssetCategory();
	}

	@Test
	void testGetId() {
		Long id = 10L;
		assetCategory.setId(id);
		
		assertEquals(id, assetCategory.getId());
	}

	@Test
	void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDescription() {
		fail("Not yet implemented");
	}

}
