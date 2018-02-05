package com.buster;

import com.buster.model.ManyEntity;
import com.buster.model.OneEntity;
import com.buster.repository.ManyRepository;
import com.buster.repository.OneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class Buster {

    @Autowired
    OneRepository oneRepository;

    @Autowired
    ManyRepository manyRepository;

    public Buster(OneRepository oneRepository, ManyRepository manyRepository) {
        IntStream
                .range(1, 1000)
                .forEach(l -> {
                    OneEntity o = OneEntity.builder().oneEntityId(l).build();
                    oneRepository.save(o);

                    IntStream
                            .range(1, 10)
                            .forEach(l2 -> {
                                ManyEntity manyEntity = ManyEntity
                                        .builder()
                                        .oneEntity(o)
                                        .manyEntityId(l * l2)
                                        .someNumber(4).build();
                                manyRepository.save(manyEntity);
                            });
                });


        manyRepository.flush();


    }

    @Scheduled(fixedDelay = 5000)
    public void continuouslyBust() {
        List<OneEntity> oS = oneRepository.findByManyEntitiesSomeNumber(4);

        System.out.println("BUSTED. Hibernate has just thrown 1000 + 1 queries at the database.");
    }
}
