package com.example.demoServer2.mapper;

import com.example.demoServer2.dto.MaterialGetDto;
import com.example.demoServer2.dto.MaterialPostDto;
import com.example.demoServer2.entity.Material;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialGetDto materialToMaterialGetDto(Material material);
    MaterialPostDto materialToMaterialPostDto(Material material);
    Material materialPostDtoToMaterial(MaterialPostDto materialPostDto) ;
    List<MaterialGetDto> getAll(List<Material> material);

}
