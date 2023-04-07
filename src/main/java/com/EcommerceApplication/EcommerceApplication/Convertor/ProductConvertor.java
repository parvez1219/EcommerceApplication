package com.EcommerceApplication.EcommerceApplication.Convertor;

import com.EcommerceApplication.EcommerceApplication.Enum.ProductStatus;
import com.EcommerceApplication.EcommerceApplication.Model.Product;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.ProductRequestDto;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.ProductResponseDto;

public class ProductConvertor {
    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .productCategory(productRequestDto.getProductCategory())
                .build();
    }
    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}
