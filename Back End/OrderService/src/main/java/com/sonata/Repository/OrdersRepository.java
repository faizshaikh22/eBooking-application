package com.sonata.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.sonata.Modal.Orders;
import com.sonata.Modal.User;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	public List<Orders> findByUserId(long u);
	public ResponseEntity<?> deleteByUserId(Long u);
}
