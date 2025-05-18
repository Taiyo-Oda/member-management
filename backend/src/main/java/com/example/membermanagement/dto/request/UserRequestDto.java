package com.example.membermanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
  private String userName;
  private String mailAddress;
  private String password;
}
