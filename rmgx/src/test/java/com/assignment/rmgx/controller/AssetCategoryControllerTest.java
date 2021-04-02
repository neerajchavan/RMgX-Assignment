package com.assignment.rmgx.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.rmgx.model.AssetCategory;
import com.assignment.rmgx.service.AssetCategoryService;

@WebMvcTest(controllers = AssetCategoryController.class)
public class AssetCategoryControllerTest {

	@MockBean
	private AssetCategoryService acService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetAllAssetCategory() throws Exception {
		
		AssetCategory ac1 = new AssetCategory(1L, "Category 1", "Description 1");
		AssetCategory ac2 = new AssetCategory(2L, "Category 2", "Description 2");
		List<AssetCategory> acList = new ArrayList<>();
		acList.add(ac1);
		acList.add(ac2);
		
		
		when(acService.getCategories()).thenReturn(acList);
		
		
		mockMvc.perform(MockMvcRequestBuilders.get("/asset-category"))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Category 1")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].description", Matchers.is("Description 1")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Category 2")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].description", Matchers.is("Description 2")));
	}

	@Test
	@DisplayName("Test - Get Asset Category By ID")
	void testGetAssetCategory() throws Exception {
		AssetCategory ac1 = new AssetCategory(1L, "Category 1", "Description 1");
		when(acService.getCategoryById(1L)).thenReturn(ac1);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/asset-category/{id}", 1L))
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Category 1")))
		.andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("Description 1")));
	}

}
