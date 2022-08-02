package com.ndeng.pointsService.entity;

import com.ndeng.pointsService.request.SpendRequest;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

/**
 * Entity for spends.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class SpendEntity {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String customer;
    @Column(nullable = false)
    private int points;
    @Column(nullable = false)
    private Instant instant;

    public SpendEntity(SpendRequest request) {
        this.customer = request.getCustomer();;
        this.points = request.getPoints();;
        this.instant = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SpendEntity that = (SpendEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
