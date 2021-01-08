package com.devlins.dsdeliver.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devlins.dsdeliver.entities.Order;

						//CAMADA DE ACESSO A DADOS

public interface OrderRepository extends JpaRepository<Order, Long> {

}
