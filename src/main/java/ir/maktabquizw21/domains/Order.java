package ir.maktabquizw21.domains;

import ir.maktabquizw21.domains.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Order extends BaseEntity<Long> {

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private double totalPrice;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private Set<OrderItem> orderItems;


    public void calculateTotalPrice() {

        this.totalPrice = orderItems.stream()
                .mapToDouble(item ->
                        item.getFruit().getPricePerKg() *
                                item.getWeight())
                .sum();
    }
}
