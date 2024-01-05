package com.vti.finalexam.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CarCreateForm {
    @NotBlank
    @Length(max = 10)
    private String licensePlate;

    @NotNull
    @PastOrPresent
    private LocalDate repairDate;

    @NotBlank
    @Length(max = 50)
    private String customerName;

    @NotBlank
    @Length(max = 50)
    private String catalogs;

    @NotBlank
    @Length(max = 50)
    private String carMaker;
}
