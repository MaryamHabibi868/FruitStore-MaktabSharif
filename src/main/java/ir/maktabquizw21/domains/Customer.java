package ir.maktabquizw21.domains;

import ir.maktabquizw21.domains.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
