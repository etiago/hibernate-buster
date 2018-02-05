package com.buster.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"oneEntityId"})
public class OneEntity {
    @Id
    @Column
    private Integer oneEntityId;

    @OneToMany(mappedBy = "oneEntity", fetch = FetchType.EAGER)
    private List<ManyEntity> manyEntities;
}
