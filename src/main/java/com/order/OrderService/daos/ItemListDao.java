package com.order.OrderService.daos;

import com.order.OrderService.models.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListDao extends JpaRepository<ItemList, Long> {

}