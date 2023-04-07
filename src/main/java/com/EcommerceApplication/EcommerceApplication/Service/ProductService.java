package com.EcommerceApplication.EcommerceApplication.Service;

import com.EcommerceApplication.EcommerceApplication.Convertor.ProductConvertor;
import com.EcommerceApplication.EcommerceApplication.Enum.ProductCategory;
import com.EcommerceApplication.EcommerceApplication.Exception.SellerNotFoundException;
import com.EcommerceApplication.EcommerceApplication.Model.Product;
import com.EcommerceApplication.EcommerceApplication.Model.Seller;
import com.EcommerceApplication.EcommerceApplication.Repository.ProductRepository;
import com.EcommerceApplication.EcommerceApplication.Repository.SellerRepository;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.ProductRequestDto;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException{
        Seller seller;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        } catch (Exception e) {
            throw new SellerNotFoundException("Invalid Seller Id");
        }
        Product product  = ProductConvertor.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProductList().add(product);
        sellerRepository.save(seller);
        ProductResponseDto productResponseDto = ProductConvertor.ProductToProductResponseDto(product);
        productRepository.save(product);
        return productResponseDto;
    }
    public List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory){
        List<Product> productList = productRepository.findAllByProductCategory(productCategory);
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : productList){
            productResponseDtoList.add(ProductConvertor.ProductToProductResponseDto(product));
        }
        return productResponseDtoList;
    }
}