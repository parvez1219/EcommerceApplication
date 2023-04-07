package com.EcommerceApplication.EcommerceApplication.RequestDTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {
    private int productId;
    private int customerId;
    private int requiredQuantity;
}
