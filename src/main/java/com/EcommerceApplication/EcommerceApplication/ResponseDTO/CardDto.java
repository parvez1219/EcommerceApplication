package com.EcommerceApplication.EcommerceApplication.ResponseDTO;

import com.EcommerceApplication.EcommerceApplication.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {
    private String cardNo;
    private CardType cardType;
}