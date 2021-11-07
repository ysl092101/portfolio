package com.stone.webapp.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.stone.ui_member.MemberController;
import com.stone.common_member.Member;
import com.stone.service_member.IMemberService;

import config.MvcConfig;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes={MvcConfig.class})
@WebAppConfiguration
public class MemberControllerTest {

	@Mock private IMemberService memberService;
	@InjectMocks private MemberController memberController;

	private MockMvc mockMvc;
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(memberController)
				.addFilter(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}

	@Test
	public void process1_test() throws Exception {
		Member member1 = new Member();
		member1.setNo(1);
		member1.setName("이름");

		Mockito.when(memberService.process1(1)).thenReturn(member1);			

		Map<String,Object> model= mockMvc.perform(get("/member/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("개인정보"))
				.andReturn().getModelAndView().getModel();

		Member aMember = (Member)model.get("member");
		Assertions.assertEquals(aMember.getName(),"이름");
	}
}