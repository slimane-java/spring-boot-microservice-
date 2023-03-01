package com.example.demoServer2.api;

import com.example.demoServer2.dto.MaterialPostDto;
import com.example.demoServer2.dto.MaterialGetDto;
import com.example.demoServer2.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/materials")
@RequiredArgsConstructor
@Log4j2
public class ApiController {

    @Autowired
    private  MaterialService materialService;

    @GetMapping("/myLog")
    public void testLog() {
        MaterialGetDto dto = new MaterialGetDto();

        log.warn("this is my log");
        log.error("errro");


    }

    @PostMapping("/create")
    @Caching(evict = {@CacheEvict(value = "materialList", allEntries = true)},
            put = {@CachePut(value = "material")})
    public MaterialGetDto create(@RequestBody MaterialPostDto materialPostDto){
        System.out.println("materialPostDto" + materialPostDto.toString());

        return materialService.add(materialPostDto);
    }

    @PutMapping("/update/{id}")
    @Caching(evict = {@CacheEvict(value = "materialList", allEntries = true)},
            put = {@CachePut(value = "material", key = "#id")})
    public MaterialGetDto update(@PathVariable("id") Long id ,@RequestBody MaterialPostDto materialPostDto) throws ClassNotFoundException {
        System.out.println("materialPostDto" + materialPostDto.toString());

        return materialService.update(id, materialPostDto);
    }

    @GetMapping("/get/{id}")
    @Cacheable(value = "material", key = "#id")
    public MaterialGetDto getById(@PathVariable("id") Long id) {

        System.out.println("id" + id);
        return materialService.getById(id);
    }

    @GetMapping("/all")
    @Cacheable(value = "materialList")
    public List<MaterialGetDto> all() {
        materialService.all().forEach(materialGetDto -> {
            log.info("respance => " + materialGetDto.toString() );
        });
        return materialService.all();
    }



}
