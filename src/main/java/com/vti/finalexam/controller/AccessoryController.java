package com.vti.finalexam.controller;

import com.vti.finalexam.dto.AccessoryDto;
import com.vti.finalexam.form.AccessoryCreateForm;
import com.vti.finalexam.form.AccessoryUpdateForm;
import com.vti.finalexam.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@CrossOrigin("http://127.0.0.1:5500/")
public class AccessoryController {
    private final AccessoryService accessoryService;

    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessoryService.findAll(pageable);
    }

    @PostMapping("/api/v1/accessories")
    public AccessoryDto create(@RequestBody @Valid AccessoryCreateForm form){
        return accessoryService.create(form);
    }

    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(@RequestBody @Valid AccessoryUpdateForm form,@PathVariable("id") Long id){
        return accessoryService.update(form, id);
    }

    @DeleteMapping("/api/v1/accessory/{id}")
    public void deleteById(@PathVariable("id") Long id){
        accessoryService.deleteById(id);
    }
}
