package com.beautySalon.service;

import com.beautySalon.entity.Serv;
import com.beautySalon.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository sRepo;
    public void save(Serv s){
        sRepo.save(s);
    }
    public List<Serv> getAllServices(){
        return sRepo.findAll();
    }

    public Serv getServById(int id) {
        return sRepo.findById(id).get();
    }
    public void deleteById(int id){
        sRepo.deleteById(id);
    }
}
