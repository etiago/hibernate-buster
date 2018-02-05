package com.buster.repository;

import com.buster.model.OneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface OneRepository extends JpaRepository<OneEntity, BigInteger> {
    List<OneEntity> findByManyEntitiesSomeNumber(Integer someNumber);

}
