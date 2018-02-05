package com.buster.repository;

import com.buster.model.ManyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyRepository extends JpaRepository<ManyEntity, Integer> {
}
