package com.example.membermanagement.service;

import com.example.membermanagement.dto.request.UserRequestDto;
import com.example.membermanagement.dto.service.UserDto;

public interface UserService {
  UserDto createUser(UserRequestDto requestDto);
}
