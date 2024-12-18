package com.example.membermanagement.home;

import com.example.membermanagement.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

  @Autowired MockMvc mockMvc;

  @Test
  void test_home() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home/index"));
  }
}
