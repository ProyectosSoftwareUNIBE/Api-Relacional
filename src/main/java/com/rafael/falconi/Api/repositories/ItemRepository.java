package com.rafael.falconi.Api.repositories;

import com.rafael.falconi.Api.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
