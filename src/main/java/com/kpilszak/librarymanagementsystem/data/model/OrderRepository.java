package com.kpilszak.librarymanagementsystem.data.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from Order c where c.booking_id = ?1")
    void deleteByOrderId(String orderId);

    @Override
    List<Order> findAll();
}
