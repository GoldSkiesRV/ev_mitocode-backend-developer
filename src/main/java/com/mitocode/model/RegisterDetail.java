package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RegisterDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegisterDetail;

    @ManyToOne
    @JoinColumn(name = "id_register", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_REGISTER"))
    private Register register;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSES"))
    private Courses courses;

    @Column(length = 10, nullable = false)
    private String classroom;
}
