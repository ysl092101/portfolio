package com.stone.webapp.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.stone.ui_manager.ManagerPlaceController;

import config.MvcConfig;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes={MvcConfig.class})
@WebAppConfiguration
public class ManagerPlaceControllerTest {

	@InjectMocks private ManagerPlaceController managerPlaceController;

	private MockMvc mockMvc;
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(managerPlaceController)
				.addFilter(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}

	@Test
	@DisplayName("ManagerPlaceController")
	public void 장소등록_test() throws Exception {
		mockMvc.perform(get("/manager/place"))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.model().size(0))
			.andExpect(view().name("manager/place/장소등록"));
	}
}