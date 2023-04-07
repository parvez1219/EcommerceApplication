package com.EcommerceApplication.EcommerceApplication.Convertor;

import com.EcommerceApplication.EcommerceApplication.Model.Customer;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.CustomerRequestDto;

public class CustomerConvertor {
    public static Customer CustomerRequestDtotoCustomer(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }
}