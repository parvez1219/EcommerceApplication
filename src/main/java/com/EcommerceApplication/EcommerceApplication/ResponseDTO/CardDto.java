package com.EcommerceApplication.EcommerceApplication.ResponseDTO;

import com.EcommerceApplication.EcommerceApplication.Enum.CardType;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {
    private String cardNo;
    private CardType cardType;
}