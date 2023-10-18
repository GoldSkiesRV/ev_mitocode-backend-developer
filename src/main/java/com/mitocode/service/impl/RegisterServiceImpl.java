package com.mitocode.service.impl;


import com.mitocode.dto.CoursesAndStudents;
import com.mitocode.model.Register;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.IRegisterRepository;
import com.mitocode.service.IRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RegisterServiceImpl extends CRUDImpl<Register, Integer> implements IRegisterService {
    private final IRegisterRepository repo;
    @Override
    protected IGenericRepository<Register, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<CoursesAndStudents>> coursesGroup() {

        Map<String, List<CoursesAndStudents>> coursesAndStudents = repo.findAll()
                .stream()
                .map(register -> {
                    return new CoursesAndStudents(register.getDetails().get(0).getCourses().getName(), register.getStudent().getFirstName());
                })
                .collect(Collectors.groupingBy(CoursesAndStudents::getNameCourse));

        return coursesAndStudents;
    }
}
