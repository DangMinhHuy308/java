package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CT_MONHOC")
public class CTMonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ct_monhoc_id")
    private Long ctMonHocId;

    @ManyToOne
    @JoinColumn(name = "sinhvien_id")
    private SinhVien sinhVien ;
    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private  MonHoc monHoc;

}
