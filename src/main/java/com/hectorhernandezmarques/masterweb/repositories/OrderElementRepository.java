package com.hectorhernandezmarques.masterweb.repositories;

import com.hectorhernandezmarques.masterweb.models.OrderElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderElementRepository extends JpaRepository<OrderElement, Long> {

}
