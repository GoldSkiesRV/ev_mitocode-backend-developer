package com.mitocode.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoursesDTO {

    private Integer idCourses;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String nameCourses;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 5)
    private String acronymCourses;

    private boolean statusCourses;
}
