package com.vti.finalexam.service;

import com.vti.finalexam.dto.AccessoryDto;
import com.vti.finalexam.entity.Accessory;
import com.vti.finalexam.entity.Car;
import com.vti.finalexam.form.AccessoryCreateForm;
import com.vti.finalexam.form.AccessoryUpdateForm;
import com.vti.finalexam.mapper.AccessoryMapper;
import com.vti.finalexam.repository.AccessoryRepository;
import com.vti.finalexam.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements AccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final CarRepository carRepository;

    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable).map(AccessoryMapper::map);
    }

    @Override
    public AccessoryDto create(AccessoryCreateForm form) {
        var accessory = AccessoryMapper.map(form);
        var carPk = new Car.PrimaryKey();
        carPk.setLicensePlate(form.getLicensePlate());
        carPk.setRepairDate(form.getRepairDate());
        var car = carRepository.findById(carPk).get();
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);
    }

    @Override
    public AccessoryDto update(AccessoryUpdateForm form, Long id) {
        var accessory = accessoryRepository.findById(id).get();
        AccessoryMapper.map(form, accessory);
        var savedCar = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedCar);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
