package com.devlins.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlins.dsdeliver.Repositories.OrderRepository;
import com.devlins.dsdeliver.Repositories.ProductRepository;
import com.devlins.dsdeliver.dto.OrderDTO;
import com.devlins.dsdeliver.dto.ProductDTO;
import com.devlins.dsdeliver.entities.Order;
import com.devlins.dsdeliver.entities.OrderStatus;
import com.devlins.dsdeliver.entities.Product;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		 List<Order> list = repository.findOrdersWhithProducts();		 
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
			
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
			
		
	}
	
	
	
}
