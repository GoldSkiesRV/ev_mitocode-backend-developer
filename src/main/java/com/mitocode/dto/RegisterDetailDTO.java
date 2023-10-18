package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDetailDTO {

    private Integer idRegisterDetail;

    @JsonBackReference
    private RegisterDTO register;

    @JsonIncludeProperties(value = {"idCourses"})
    @NotNull
    private CoursesDTO courses;

    @NotNull
    private String classroom;
}
