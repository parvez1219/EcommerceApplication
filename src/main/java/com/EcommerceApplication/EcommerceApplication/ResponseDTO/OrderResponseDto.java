package com.EcommerceApplication.EcommerceApplication.ResponseDTO;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private String name;
    private Date orderDate;
    private int itemPrice;
    private int quantityOrdered;
    private int totalCost;
    private int deliveryCharge;
    private String cardForPayment;
}
