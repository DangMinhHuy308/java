package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sinhvien_id")
    private Long MSSV;
    @Column(name = "sinhvien_name")
    private String fullName;
    @Column(name = "sinhvien_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngaySinh;
    @Column(name = "sinhvien_email")
    private String Email;

    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL)
    private List<CTMonHoc> ctMonHocs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "lop_id")
    private Lop lop;
}
