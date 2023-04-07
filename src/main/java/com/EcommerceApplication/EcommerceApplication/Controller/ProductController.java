package com.EcommerceApplication.EcommerceApplication.Controller;

import com.EcommerceApplication.EcommerceApplication.Enum.ProductCategory;
import com.EcommerceApplication.EcommerceApplication.Exception.SellerNotFoundException;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.ProductRequestDto;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.ProductResponseDto;
import com.EcommerceApplication.EcommerceApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto productResponseDto;
        try {
            productResponseDto=productService.addProduct(productRequestDto);
        } catch (SellerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("get/category/{productCategory}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("productCategory") ProductCategory productCategory){
        return productService.getAllProductByCategory(productCategory);
    }
}