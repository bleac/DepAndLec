package com.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Department {

    @Id
    private String id;

    private String name;

    private String headId;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "department_lector", joinColumns =
    @JoinColumn(name = "id_department"), inverseJoinColumns =
    @JoinColumn(name = "id_lector"))
    private List<Lector> lectors;
}
