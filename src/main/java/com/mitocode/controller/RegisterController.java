package com.mitocode.controller;

import com.mitocode.dto.CoursesAndStudents;
import com.mitocode.dto.RegisterDTO;
import com.mitocode.model.Register;
import com.mitocode.service.IRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final IRegisterService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity <List<RegisterDTO>> readAll() throws Exception{
        List<RegisterDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegisterDTO> create(@Valid @RequestBody RegisterDTO dto) throws Exception{
        Register obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(obj), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegisterDTO> redById(@PathVariable("id") Integer id) throws Exception{
        RegisterDTO obj = convertToDTO(service.readById(id));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RegisterDTO> update (@Valid @RequestBody RegisterDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setId(id);
        Register obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDTO(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/coursesgroup")
    public ResponseEntity<?>getCoursesGroup(){
        Map<String, List<CoursesAndStudents>> list = service.coursesGroup();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //////////////////////////
    private RegisterDTO convertToDTO(Register obj){
        return mapper.map(obj, RegisterDTO.class);
    }
    private Register convertToEntity(RegisterDTO dto){
        return mapper.map(dto, Register.class);
    }
}
