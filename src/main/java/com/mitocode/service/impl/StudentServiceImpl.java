package com.mitocode.service.impl;

import com.mitocode.model.Student;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.IStudentRepository;
import com.mitocode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository repo;
    @Override
    protected IGenericRepository<Student, Integer> getRepo() {
        return repo;
    }
    @Override
    public List<Student> OrderByAge(String param) {
        Sort.Direction direction = param.equalsIgnoreCase("ASC")? Sort.Direction.ASC : Sort.Direction.DESC;
        return repo.findAll(Sort.by(direction,"age"));
    }
}
