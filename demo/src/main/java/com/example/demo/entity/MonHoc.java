package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "MONHOC")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monhoc_id")
    private Long maMon;
    @Column(name = "monhoc_name")
    private String tenMon;
    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
    private List<CTMonHoc> ctMonHocs = new ArrayList<>();
}

