package com.EcommerceApplication.EcommerceApplication.RequestDTO;

import com.EcommerceApplication.EcommerceApplication.Enum.ProductCategory;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {
    private int sellerId;
    private String name;
    private int price;
    private int quantity;
    private ProductCategory productCategory;
}
