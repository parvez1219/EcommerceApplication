package com.EcommerceApplication.EcommerceApplication.Convertor;

import com.EcommerceApplication.EcommerceApplication.Model.Seller;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.SellerRequestDto;

public class SellerConvertor {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
}
