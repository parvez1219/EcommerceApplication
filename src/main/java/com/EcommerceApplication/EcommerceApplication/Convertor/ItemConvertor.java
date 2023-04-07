package com.EcommerceApplication.EcommerceApplication.Convertor;

import com.EcommerceApplication.EcommerceApplication.Model.Product;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.ItemResponseDto;

public class ItemConvertor {
    public static ItemResponseDto ProductToItemResponseDto(Product product){
        return ItemResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}
