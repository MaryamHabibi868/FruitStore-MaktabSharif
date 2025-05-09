package ir.maktabquizw21.domains;

import ir.maktabquizw21.domains.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<Long> {

    @NotBlank
    private String name;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
