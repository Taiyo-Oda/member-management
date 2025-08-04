package com.example.membermanagement.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.membermanagement.config.SecurityConfig;
import com.example.membermanagement.dto.request.UserRequestDto;
import com.example.membermanagement.dto.service.UserDto;
import com.example.membermanagement.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

  @Autowired MockMvc mockMvc;

  @Autowired ObjectMapper objectMapper;

  @MockitoBean UserServiceImpl userServiceImpl;

  /** テスト用のJSONファイルを読み込むユーティリティメソッド */
  private String readJsonFile(String filePath) throws IOException {
    ClassPathResource resource = new ClassPathResource(filePath);
    return new String(Files.readAllBytes(Paths.get(resource.getURI())));
  }

  @Test
  @DisplayName("createUserのテスト")
  void testCreateUser() throws Exception {
    // リクエストDTOの準備
    UserRequestDto requestDto = new UserRequestDto();
    requestDto.setMailAddress("test@mail.com");
    requestDto.setPassword("testPassword");

    // モックサービスの戻り値を設定
    UserDto responseDto = new UserDto();
    responseDto.setUserId(1);
    responseDto.setUserName("testUser");
    responseDto.setMailAddress("test@mail.com");
    responseDto.setCreatedAt(LocalDateTime.of(2025, 5, 1, 0, 0));

    doReturn(responseDto).when(userServiceImpl).createUser(any(UserRequestDto.class));

    // 期待値JSONファイルの読み込み
    String expectedJson =
        readJsonFile("expected/UserControllerTest.testCreateUser/user-response.json");

    // リクエスト実行と検証
    mockMvc
        .perform(
            post("/api/v1/users")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
        .andExpect(status().isCreated())
        .andExpect(content().json(expectedJson));
  }

  @Test
  @DisplayName("メールアドレスが空の場合のバリデーションエラーテスト")
  void testCreateUser_EmptyEmail() throws Exception {
    // 不正なリクエストDTOの準備
    UserRequestDto requestDto = new UserRequestDto();
    requestDto.setMailAddress(""); // 空のメールアドレス
    requestDto.setPassword("testPassword01");

    // リクエスト実行と検証
    mockMvc
        .perform(
            post("/api/v1/users")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.mailAddress").exists()); // エラーメッセージの存在確認
  }

  @Test
  @DisplayName("パスワードが短い場合のバリデーションエラーテスト")
  void testCreateUser_ShortPassword() throws Exception {
    UserRequestDto requestDto = new UserRequestDto();
    requestDto.setMailAddress("test@mail.com");
    requestDto.setPassword("short"); // 8文字未満のパスワード

    mockMvc
        .perform(
            post("/api/v1/users")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.password").exists());
  }
}
