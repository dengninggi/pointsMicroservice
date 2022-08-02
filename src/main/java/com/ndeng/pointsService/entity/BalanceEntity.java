package com.ndeng.pointsService.entity;

import com.ndeng.pointsService.response.BalanceDetail;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

/**
 * Entity for balance details.
 * An entity can be consumed by the customer in chronological order.
 */
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BalanceEntity {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    /** who earns it */
    @Column(nullable = false)
    private String customer;
    /** who should pay for it at spending */
    @Column(nullable = false)
    private String payer;
    /** how many points that customer earns */
    @Column(nullable = false)
    private int points;
    /** when were points earned */
    @Column(nullable = false)
    private Instant instant;

    public BalanceEntity(String customer, BalanceDetail balanceDetail) {
        this.customer = customer;
        this.payer = balanceDetail.getPayer();
        this.points = balanceDetail.getPoints();
        this.instant = Instant.parse(balanceDetail.getTimestamp());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BalanceEntity entity = (BalanceEntity) o;
        return id != null && Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
