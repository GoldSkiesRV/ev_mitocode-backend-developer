package com.mitocode.service.impl;

import com.mitocode.model.Courses;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.ICoursesRepository;
import com.mitocode.service.ICoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl extends CRUDImpl<Courses, Integer> implements ICoursesService {

    private final ICoursesRepository repo;
    @Override
    protected IGenericRepository<Courses, Integer> getRepo() {
        return repo;
    }
}
