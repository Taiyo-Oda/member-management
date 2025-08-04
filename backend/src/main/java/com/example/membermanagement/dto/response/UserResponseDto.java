package com.example.membermanagement.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
  private Integer userId;
  private String userName;
  private String mailAddress;
  private LocalDateTime createdAt;
}
