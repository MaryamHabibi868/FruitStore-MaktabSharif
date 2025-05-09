package ir.maktabquizw21.domains;

import ir.maktabquizw21.domains.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "manager_id")
public class Manager extends User {
}
