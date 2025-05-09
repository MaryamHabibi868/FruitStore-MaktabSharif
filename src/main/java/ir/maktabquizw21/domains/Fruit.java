package ir.maktabquizw21.domains;

import ir.maktabquizw21.domains.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Fruit extends BaseEntity<Long> {

    @NotBlank (message = "Name of fruit should be entered")
    private String name;

    private String description;

    @NotBlank
    @Digits(integer = 1000, fraction = 2)
    @Min(0)
    @Max(100_000)
    private Double quantity;

    @NotBlank
    @Digits(integer = 1000, fraction = 2)
    private Double pricePerKg;
}
