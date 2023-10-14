package com.github.bkwak.springparkingapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long user_id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String token;

}
