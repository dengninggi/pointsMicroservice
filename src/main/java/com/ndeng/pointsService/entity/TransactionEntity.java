package com.ndeng.pointsService.entity;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

/**
 * Entity for transactions.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class TransactionEntity {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String customer;
    @Column(nullable = false)
    private String payer;
    @Column(nullable = false)
    private int points;
    @Column(nullable = false)
    private Instant instant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TransactionEntity that = (TransactionEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
