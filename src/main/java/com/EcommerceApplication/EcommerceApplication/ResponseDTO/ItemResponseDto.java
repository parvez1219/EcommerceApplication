package com.EcommerceApplication.EcommerceApplication.ResponseDTO;

import com.EcommerceApplication.EcommerceApplication.Enum.ProductCategory;
import com.EcommerceApplication.EcommerceApplication.Enum.ProductStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponseDto {
    private String name;
    private int price;
    private ProductCategory productCategory;
    private ProductStatus productStatus;
}
