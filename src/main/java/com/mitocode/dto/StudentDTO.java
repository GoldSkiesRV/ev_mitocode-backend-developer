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
public class StudentDTO {

    private Integer idStudent;


    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String firstNameStudent;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String lastNameStudent;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 8, message = "dni min 6")
    private String dniStudent;

    @Min(value = 10)
    @Max(value = 99)
    private int ageStudent;

}
