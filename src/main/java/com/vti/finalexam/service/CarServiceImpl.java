package com.vti.finalexam.service;

import com.vti.finalexam.dto.CarDto;
import com.vti.finalexam.entity.Car;
import com.vti.finalexam.form.CarCreateForm;
import com.vti.finalexam.form.CarUpdateForm;
import com.vti.finalexam.mapper.CarMapper;
import com.vti.finalexam.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return carRepository.findAll(pageable).map(CarMapper::map);
    }

    @Override
    public CarDto create(CarCreateForm form) {
        var car = CarMapper.map(form);
        var savedCar = carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public CarDto update(CarUpdateForm form) {
        var carPk = new Car.PrimaryKey();
        carPk.setLicensePlate(form.getLicensePlate());
        carPk.setRepairDate(form.getRepairDate());
        var car = carRepository.findById(carPk).get();
        CarMapper.map(form, car);
        var savedCar = carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public void deleteById(Car.PrimaryKey id) {
        carRepository.deleteById(id);
    }
}
