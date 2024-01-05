package com.vti.finalexam.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class AccessoryUpdateForm {
    @NotBlank
    @Length(max = 50)
    private String name;

    @NotNull
    @PositiveOrZero
    private Long price;

    @NotBlank
    @Length(max = 50)
    private String statusDamaged;

    @NotBlank
    @Length(max = 50)
    private String repairStatus;
}