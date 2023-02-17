package com.beautySalon.controller;

import com.beautySalon.entity.MyServicesList;
import com.beautySalon.entity.Serv;
import com.beautySalon.service.MyServicesListService;
import com.beautySalon.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService service;

    @Autowired
    private MyServicesListService myServiceService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/service_register")
    public String serviceRegister() {
        return "serviceRegister";
    }

    @GetMapping("/available_services")
    public ModelAndView getAllServices() {
        List<Serv> list = service.getAllServices();
//        ModelAndView m= new ModelAndView();
//        m.setViewName("servicesList");
//        m.addObject("service", list);
//        return m;
        return new ModelAndView("servicesList", "serv", list);
    }

    @PostMapping("/save")
    public String addService(@ModelAttribute Serv s) {
        service.save(s);
        return "redirect:/available_services";
    }

    @GetMapping("/myServices")
    public String getMyServices(Model model) {
        List<MyServicesList> list = myServiceService.getAllMyServices();
        model.addAttribute("serv", list);
        return "myServices";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Serv s = service.getServById(id);
        MyServicesList sl = new MyServicesList(s.getId(), s.getName(), s.getAuthor(), s.getPrice());
        myServiceService.saveMyServices(sl);
        return "redirect:/myServices";
    }

    @RequestMapping("/editService/{id}")
    public String editService(@PathVariable("id") int id, Model model) {
        Serv s = service.getServById(id);
        model.addAttribute("serv", s);
        return "serviceEdit";
    }

    @RequestMapping("deleteService/{id}")
    public String deleteService(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_services";
    }
}