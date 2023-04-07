package com.EcommerceApplication.EcommerceApplication.Service;

import com.EcommerceApplication.EcommerceApplication.Enum.ProductStatus;
import com.EcommerceApplication.EcommerceApplication.Exception.CustomerNotFoundException;
import com.EcommerceApplication.EcommerceApplication.Exception.InsufficientQuantity;
import com.EcommerceApplication.EcommerceApplication.Exception.ProductNotFoundException;
import com.EcommerceApplication.EcommerceApplication.Model.*;
import com.EcommerceApplication.EcommerceApplication.Repository.CustomerRepository;
import com.EcommerceApplication.EcommerceApplication.Repository.ProductRepository;
import com.EcommerceApplication.EcommerceApplication.RequestDTO.OrderRequestDto;
import com.EcommerceApplication.EcommerceApplication.ResponseDTO.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderService orderService;

    @Autowired
    JavaMailSender emailSender;
    public String addToCart(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantity {
        Customer customer;
        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid Customer id !!!!");
        }

        Product product;
        try {
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Invalid Product Id !!!!!");
        }

        if(product.getQuantity()<orderRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantity("Sorry !!!!! Required Quantity Not Available");
        }

        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal()+orderRequestDto.getRequiredQuantity()*product.getPrice());

        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setCart(cart);
        item.setProduct(product);
        cart.getItemList().add(item);

        customerRepository.save(customer);

        return "Item has been added to your Cart ";
    }

    public List<OrderResponseDto> checkoutCart(int customerId) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantity {
        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid Customer id !!!!");
        }

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        int cartTotal = customer.getCart().getCartTotal();
        Cart cart = customer.getCart();
        for(Item item : cart.getItemList()){
            Ordered ordered = new Ordered();
            ordered.setTotalCost(item.getRequiredQuantity()*item.getProduct().getPrice());
            ordered.setDeliveryCharge(0);
            ordered.setCustomer(customer);
            ordered.getItemList().add(item);

            Card card = customer.getCardList().get(0);
            String cardNo="";
            for(int i=0;i<card.getCardNo().length()-4;i++){
                cardNo+='x';
            }
            cardNo+=card.getCardNo().substring(card.getCardNo().length()-4);
            ordered.setCardUsedForPayment(cardNo);

            int leftQuantity = item.getProduct().getQuantity()-item.getRequiredQuantity();
            if(leftQuantity<=0){
                item.getProduct().setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
            item.getProduct().setQuantity(leftQuantity);

            customer.getOrderedList().add(ordered);

            // prepare Response dto
            OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                    .name(item.getProduct().getName())
                    .orderDate(ordered.getOrderDate())
                    .quantityOrdered(item.getRequiredQuantity())
                    .cardForPayment(cardNo)
                    .deliveryCharge(40)
                    .itemPrice(item.getProduct().getPrice())
                    .totalCost(ordered.getTotalCost())
                    .build();

            orderResponseDtos.add(orderResponseDto);
        }
        cart.setItemList(new ArrayList<>());
        cart.setCartTotal(0);
        customerRepository.save(customer);

        // sends an email
        String text = "Congrats !!! Your order with total value  " + cartTotal + " has been placed";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("email");
        message.setTo(customer.getEmail());
        message.setSubject("Order Placed");
        message.setText(text);
        emailSender.send(message);
        return orderResponseDtos;
    }
}