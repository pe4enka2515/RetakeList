package com.example.retake.service;

import com.example.retake.model.Retake;
import com.example.retake.repository.RetakeRepository;
import org.apache.catalina.filters.RateLimitFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetakeService {

    private final RetakeRepository retakeRepository;

    @Autowired
    public RetakeService(RetakeRepository retakeRepository) {
        this.retakeRepository = retakeRepository;
    }
    public Retake findById(Long id){
        return retakeRepository.getOne(id);
    }

    public List<Retake> findAll(){
        return retakeRepository.findAll();
    }

    public Retake saveRetake(Retake retake){
        return retakeRepository.save(retake);
    }

    public void deleteById(Long id){
        retakeRepository.deleteById(id);
    }
}
