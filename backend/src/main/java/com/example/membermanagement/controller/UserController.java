package com.example.membermanagement.controller;

import com.example.membermanagement.dto.request.UserRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createUser(@RequestBody UserRequestDto requestDto) {
    return null;
  }
}
