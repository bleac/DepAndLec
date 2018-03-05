package com.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Lector {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Enumerated
    private Degree degree;

    @ManyToMany
    @JoinTable(name = "department_lector", joinColumns =
    @JoinColumn(name = "id_lector"), inverseJoinColumns =
    @JoinColumn(name = "id_department"))
    private List<Department> departments;

}
