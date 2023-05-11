package com.sonata.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonata.Modal.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByEventCategory(String category);
	List<Event> findByEventName(String name);
}
