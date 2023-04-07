package com.EcommerceApplication.EcommerceApplication.ResponseDTO;

import com.EcommerceApplication.EcommerceApplication.Enum.ProductStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private String name;
    private int price;
    private int quantity;
    private ProductStatus productStatus;
}
