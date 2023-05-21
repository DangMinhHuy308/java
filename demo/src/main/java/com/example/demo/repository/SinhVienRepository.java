package com.example.demo.repository;

import com.example.demo.entity.SinhVien;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
    /*List<SinhVien> findAllById(Long id, Pageable pageable);*/
}
