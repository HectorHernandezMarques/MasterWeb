package com.hectorhernandezmarques.masterweb.repositories;

import com.hectorhernandezmarques.masterweb.models.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder, Long> {

}
