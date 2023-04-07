package com.EcommerceApplication.EcommerceApplication.Service;

import com.EcommerceApplication.EcommerceApplication.Convertor.ItemConvertor;
import com.EcommerceApplication.EcommerceApplication.Exception.ProductNotFoundException;
import com.EcommerceApplication.EcommerceApplication.Model.Item;
import com.EcommerceApplication.EcommerceApplication.Model.Product;
import com.EcommerceApplication.EcommerceApplication.Repository.ProductRepository;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try{
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Sorry Invalid product Id");
        }
        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
        product.setItem(item);
        productRepository.save(product);

        ItemResponseDto itemResponseDto = ItemConvertor.ProductToItemResponseDto(product);
        return itemResponseDto;
    }
}