package com.EcommerceApplication.EcommerceApplication.Controller;

import com.EcommerceApplication.EcommerceApplication.Model.Seller;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.SellerRequestDto;
import com.EcommerceApplication.EcommerceApplication.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;
    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        return sellerService.addSeller(sellerRequestDto);
    }
    //get all seller
    @GetMapping("/getallSeller")
    public List<Seller> getAllSeller(){
        return sellerService.getAllSeller();
    }
}