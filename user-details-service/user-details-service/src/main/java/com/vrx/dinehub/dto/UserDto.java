package com.vrx.dinehub.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String address;
    private String city;
}
