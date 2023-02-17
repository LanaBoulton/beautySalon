package com.beautySalon.repository;

import com.beautySalon.entity.Serv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Serv, Integer> {
}
