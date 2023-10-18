package com.mitocode.service;

import com.mitocode.dto.CoursesAndStudents;
import com.mitocode.model.Register;

import java.util.List;
import java.util.Map;

public interface IRegisterService extends ICRUD<Register, Integer> {
    Map<String, List<CoursesAndStudents>> coursesGroup();
}
