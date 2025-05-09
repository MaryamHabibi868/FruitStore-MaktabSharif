package ir.maktabquizw21.domains;

import ir.maktabquizw21.domains.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User {

    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
