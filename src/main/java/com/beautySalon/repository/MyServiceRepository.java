package com.beautySalon.repository;

import com.beautySalon.entity.MyServicesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyServiceRepository extends JpaRepository <MyServicesList, Integer> {

}
