package com.example.demo.services;

import com.example.demo.entity.SinhVien;
import com.example.demo.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;

    //nguyen ban
    public List<SinhVien> getAllSinhVien(){
        return sinhVienRepository.findAll();
    }

    //test
    /*public Page<SinhVien> getAllSinhVien() {
        Pageable pageable = PageRequest.of(0,10);
        return sinhVienRepository.findAll(pageable);
    }*/

    //dang su dung
    public Page<SinhVien> getAllSinhVien(Pageable pageable) {
        return sinhVienRepository.findAll(pageable);
    }

    // chua su dung
    /*public Page<SinhVien> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField).ascending();
        if (sortDirection.equalsIgnoreCase(Sort.Direction.DESC.name())) {
            sort = sort.descending();
        }

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.sinhVienRepository.findAll(pageable);
    }*/

    public SinhVien getSinhVienById(Long id){
        Optional<SinhVien> optional = sinhVienRepository.findById(id);
        return optional.orElse(null);
    }
    public void addSinhVien(SinhVien sinhvien) {
        sinhVienRepository.save(sinhvien);
    }

    public void editSinhVien(SinhVien sinhvien) {
        sinhVienRepository.save(sinhvien);
    }

    public void deleteSinhVien(Long id) {
        sinhVienRepository.deleteById(id);
    }
}
