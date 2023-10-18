package com.mitocode.controller;

import com.mitocode.dto.CoursesDTO;
import com.mitocode.model.Courses;
import com.mitocode.service.ICoursesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final ICoursesService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity <List<CoursesDTO>> readAll() throws Exception{
        List<CoursesDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CoursesDTO> create(@Valid @RequestBody CoursesDTO dto) throws Exception{
        Courses obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(obj), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CoursesDTO> redById(@PathVariable("id") Integer id) throws Exception{
        CoursesDTO obj = convertToDTO(service.readById(id));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CoursesDTO> update (@Valid @RequestBody CoursesDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setIdCourses(id);
        Courses obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDTO(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//////////////////////////
    private CoursesDTO convertToDTO(Courses obj){
        return mapper.map(obj, CoursesDTO.class);
    }
    private Courses convertToEntity(CoursesDTO dto){
        return mapper.map(dto, Courses.class);
    }
}
