package com.mitocode.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDTO {
    private Integer id;

    @JsonIncludeProperties(value = {"idStudent"})
    @NotNull
    private StudentDTO student;

    @NotNull
    private LocalDateTime date;

    @JsonManagedReference
    @NotNull
    private List<RegisterDetailDTO> details;

    private Boolean status;
}
