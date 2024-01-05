package com.vti.finalexam.service;

import com.vti.finalexam.dto.AccessoryDto;
import com.vti.finalexam.form.AccessoryCreateForm;
import com.vti.finalexam.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto create(AccessoryCreateForm form);

    AccessoryDto update(AccessoryUpdateForm form, Long id);

    void deleteById(Long id);
}
