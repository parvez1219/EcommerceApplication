package com.EcommerceApplication.EcommerceApplication.RequestDTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDto {
    private String name;
    private int age;
    private String email;
    private String mobNo;
}
