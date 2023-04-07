package com.EcommerceApplication.EcommerceApplication.Convertor;

import com.EcommerceApplication.EcommerceApplication.Model.Card;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.CardRequestDto;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.CardResponseDto;

public class CardConvertor {
    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .build();
    }
    public static CardResponseDto CardToCardResponseDto(Card card){
        return CardResponseDto.builder().build();
    }
}
