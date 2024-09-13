package org.example.managerdemo.repository;

import org.example.managerdemo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
