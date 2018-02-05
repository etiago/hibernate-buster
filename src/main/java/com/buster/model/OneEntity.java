package com.buster.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @Fetch(value = FetchMode.JOIN)
    @OneToMany(mappedBy = "oneEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ManyEntity> manyEntities;
}
