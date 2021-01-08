package com.devlins.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlins.dsdeliver.Repositories.OrderRepository;
import com.devlins.dsdeliver.dto.OrderDTO;
import com.devlins.dsdeliver.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		 List<Order> list = repository.findOrdersWhithProducts();		 
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
		
	}
}
