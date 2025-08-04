package com.example.membermanagement.controller;

import com.example.membermanagement.dto.request.UserRequestDto;
import com.example.membermanagement.dto.response.UserResponseDto;
import com.example.membermanagement.dto.service.UserDto;
import com.example.membermanagement.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @Autowired
  public UserController(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  /**
   * ユーザー登録API
   *
   * @param requestDto ユーザー登録リクエストDTO
   * @return ユーザー登録レスポンスDTO
   */
  @PostMapping
  public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto requestDto) {
    UserDto userDto = userServiceImpl.createUser(requestDto);

    UserResponseDto responseDto = new UserResponseDto();
    responseDto.setUserId(userDto.getUserId());
    responseDto.setUserName(userDto.getUserName());
    responseDto.setMailAddress(userDto.getMailAddress());
    responseDto.setCreatedAt(userDto.getCreatedAt());

    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }
}
