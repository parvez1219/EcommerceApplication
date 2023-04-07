package com.EcommerceApplication.EcommerceApplication.Controller;

import com.EcommerceApplication.EcommerceApplication.Exception.ProductNotFoundException;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.ItemResponseDto;
import com.EcommerceApplication.EcommerceApplication.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId){
        ItemResponseDto itemResponseDto;
        try {
            itemResponseDto = itemService.viewItem(productId);

        } catch (ProductNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(itemResponseDto,HttpStatus.ACCEPTED);
    }

}