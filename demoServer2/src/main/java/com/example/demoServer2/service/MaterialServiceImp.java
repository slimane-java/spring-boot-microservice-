package com.example.demoServer2.service;

import com.example.demoServer2.dao.MaterialRepository;
import com.example.demoServer2.dto.MaterialGetDto;
import com.example.demoServer2.dto.MaterialPostDto;
import com.example.demoServer2.entity.Material;
import com.example.demoServer2.mapper.MaterialMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MaterialServiceImp implements MaterialService{
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    private static final String REDIS_CACHE_VALUE = "material";

    @Override
    public MaterialGetDto add(MaterialPostDto materialPostDto) {
        Material material = materialMapper.materialPostDtoToMaterial(materialPostDto);
        System.out.println("material : " + material.toString());
        return materialMapper.materialToMaterialGetDto(materialRepository.save(material));
    }

    @Override
    public MaterialGetDto getById(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        return materialMapper.materialToMaterialGetDto(material.orElseThrow(()->new RuntimeException("Not Found")));
    }

    @Override
    public List<MaterialGetDto> all() {
        return materialMapper.getAll(materialRepository.findAll());
    }

    @Override
    public MaterialGetDto update(Long id, MaterialPostDto materialPostDto) {
        Optional<Material> materialFetch = materialRepository.findById(id);
        if(!materialFetch.isPresent()){
            throw new RuntimeException("this material not found ");
        }else {
            System.out.println("user" + materialFetch.get().getId());
            materialFetch.get().setCode(materialPostDto.getCode());
            materialFetch.get().setString(materialPostDto.getString());
            materialFetch.get().setPrice(materialPostDto.getPrice());
            materialFetch.get().setDateRun(materialPostDto.getDateRun());
            materialFetch.get().setDateBuy(materialPostDto.getDateBuy());
            return materialMapper.materialToMaterialGetDto(materialRepository.save(materialFetch.get()));
        }

    }
}
