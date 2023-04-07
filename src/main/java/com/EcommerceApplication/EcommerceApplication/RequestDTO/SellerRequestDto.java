package com.EcommerceApplication.EcommerceApplication.RequestDTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequestDto {
    private String name;
    private String mobNo;
    private String email;
    private String panNo;

}