package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lop_id")
    private Long maLop;
    @Column(name = "lop_name")
    private String tenLop;

    @OneToMany(mappedBy = "lop", cascade = CascadeType.ALL)
    private List<SinhVien> sinhViens = new ArrayList<>();
}
