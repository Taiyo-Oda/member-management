package com.example.membermanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
  @NotNull(message = "メールアドレスは必須です")
  @Email(message = "メールアドレスの形式が不正です")
  private String mailAddress;

  @NotNull(message = "パスワードは必須です")
  @Pattern(
      regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
      message = "パスワードは英数字8文字以上である必要があります")
  private String password;
}
