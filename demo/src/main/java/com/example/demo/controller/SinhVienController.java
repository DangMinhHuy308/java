package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.services.LopService;
import com.example.demo.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sinhviens")

public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private LopService lopService;
    // k su dung
    /*@GetMapping
    public String showAllSinhVien(Model model){
        List<SinhVien> sinhviens = sinhVienService.getAllSinhVien();
        model.addAttribute("sinhviens",sinhviens);
        return "sinhvien/list";
    }*/

    // dag su dung

    @GetMapping
    public String showAllSinhVien(Model model, @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "fullName") String sortField) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortField));
        Page<SinhVien> sinhviensPage = sinhVienService.getAllSinhVien(pageable);
        model.addAttribute("sinhviens", sinhviensPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sinhviensPage.getTotalPages());
        model.addAttribute("sortField", sortField);
        return "sinhvien/list";
    }


    @GetMapping("/add")
    public String showAddSinhVienForm(Model model) {
        model.addAttribute("sinhvien", new SinhVien());
        model.addAttribute("lops", lopService.getAllLops());
        return "sinhvien/add";
    }

    @PostMapping("/add")
    public String addSinhVien(@ModelAttribute("sinhvien") SinhVien sinhvien) {
        sinhVienService.addSinhVien(sinhvien);
        return "redirect:/sinhviens";
    }


    @GetMapping("/edit/{mssv}")
    public String editSinhVienForm(@PathVariable("mssv") Long mssv, Model model) {
        SinhVien editSinhVien = sinhVienService.getSinhVienById(mssv);
        if(editSinhVien != null) {
            model.addAttribute("sinhvien", editSinhVien);
            model.addAttribute("lops", lopService.getAllLops());
            return "sinhvien/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editSinhVien(@ModelAttribute("sinhvien") SinhVien sinhvien) {
        sinhVienService.addSinhVien(sinhvien);
        return "redirect:/sinhviens";
    }

    @GetMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable("id") Long id) {
        sinhVienService.deleteSinhVien(id);
        return "redirect:/sinhviens";
    }
}
