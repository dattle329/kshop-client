package com.vti.finalexam.service;

import com.vti.finalexam.dto.CarDto;
import com.vti.finalexam.entity.Car;
import com.vti.finalexam.form.CarCreateForm;
import com.vti.finalexam.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDto> findAll(Pageable pageable);

    CarDto create(CarCreateForm form);

    CarDto update(CarUpdateForm form);

    void deleteById(Car.PrimaryKey id);
}
