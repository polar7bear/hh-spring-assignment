package com.ssg.hhassignment.repository;

import com.ssg.hhassignment.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
