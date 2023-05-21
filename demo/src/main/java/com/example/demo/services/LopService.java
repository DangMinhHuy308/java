package com.example.demo.services;

import com.example.demo.entity.Lop;
import com.example.demo.repository.LopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class LopService {
    @Autowired
    private LopRepository lopRepository;

    public List<Lop> getAllLops() {
        return lopRepository.findAll();
    }
    public Lop getLopById(Long id){
        Optional<Lop> optionalLop = lopRepository.findById(id);
        if(optionalLop.isPresent()){
            return optionalLop.get();
        }else {
            throw new RuntimeException("Lop not found");
        }
    }
    public Lop saveLop(Lop lop){
        return lopRepository.save(lop);
    }
    public void deleteLop(Long id) {
        lopRepository.deleteById(id);
    }
}
