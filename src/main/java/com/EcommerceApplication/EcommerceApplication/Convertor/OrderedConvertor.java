package com.EcommerceApplication.EcommerceApplication.Convertor;

import com.EcommerceApplication.EcommerceApplication.Model.Customer;
import com.EcommerceApplication.EcommerceApplication.Model.Ordered;
import com.EcommerceApplication.EcommerceApplication.Model.Product;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.OrderRequestDto;

public class OrderedConvertor {
    public static Ordered OrderRequestDtoToOrdered(OrderRequestDto orderRequestDto, Product product, Customer customer){
        int totalCost=orderRequestDto.getRequiredQuantity()*product.getPrice();
        int delivery=0;
        if(totalCost<500){
            delivery = 50;
            totalCost+=delivery;
        }
        return Ordered.builder()
                .totalCost(orderRequestDto.getRequiredQuantity()*product.getPrice())
                .deliveryCharge(delivery)
                .customer(customer)
                .build();
    }
}
