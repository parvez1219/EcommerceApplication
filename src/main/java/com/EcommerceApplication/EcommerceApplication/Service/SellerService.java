package com.EcommerceApplication.EcommerceApplication.Service;

import com.EcommerceApplication.EcommerceApplication.Convertor.SellerConvertor;
import com.EcommerceApplication.EcommerceApplication.Model.Seller;
import com.EcommerceApplication.EcommerceApplication.Repository.SellerRepository;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerRequestDto sellerRequestDto){
        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);
        return "Congrats! Now You Can Sell here !!!";
    }
    public List<Seller> getAllSeller(){
        List<Seller> sellers = sellerRepository.findAll();
        return sellers;
    }
}