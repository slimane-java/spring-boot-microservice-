package com.example.demoServer2.service;

import com.example.demoServer2.dto.MaterialGetDto;
import com.example.demoServer2.dto.MaterialPostDto;
import java.util.List;

public interface MaterialService {

    MaterialGetDto add(MaterialPostDto materialPostDto);
    MaterialGetDto getById(Long id);
    List<MaterialGetDto> all();

    MaterialGetDto update(Long id, MaterialPostDto materialPostDto) throws ClassNotFoundException;
}
