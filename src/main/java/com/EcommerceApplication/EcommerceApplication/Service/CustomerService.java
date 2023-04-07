package com.EcommerceApplication.EcommerceApplication.Service;

import com.EcommerceApplication.EcommerceApplication.Convertor.CustomerConvertor;
import com.EcommerceApplication.EcommerceApplication.Model.Cart;
import com.EcommerceApplication.EcommerceApplication.Model.Customer;
import com.EcommerceApplication.EcommerceApplication.Repository.CustomerRepository;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public String addCustomer(CustomerRequestDto customerRequestDto){
        Customer customer = CustomerConvertor.CustomerRequestDtotoCustomer(customerRequestDto);
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);
        customerRepository.save(customer);
        return "Congrats !!! Welcome to our shop !!!.";
    }
}