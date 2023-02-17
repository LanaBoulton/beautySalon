package com.beautySalon.service;

import com.beautySalon.entity.MyServicesList;
import com.beautySalon.repository.MyServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServicesListService {

    @Autowired
    private MyServiceRepository myService;

    public void saveMyServices(MyServicesList serv){
        myService.save(serv);
    }

    public List<MyServicesList> getAllMyServices(){
        return myService.findAll();
    }
    public void deleteById(int id){
        myService.deleteById(id);
    }
}
