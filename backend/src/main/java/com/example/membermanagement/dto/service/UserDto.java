package com.example.membermanagement.dto.service;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
public class UserDto {
  private Integer userId;
  private String userName;
  private String mailAddress;
  private LocalDateTime createdAt;
}
