package org.kotlin.learn.websellbook_backend.repository;

import org.kotlin.learn.websellbook_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
