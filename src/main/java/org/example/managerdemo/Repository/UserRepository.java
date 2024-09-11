package org.example.managerdemo.Repository;

import org.example.managerdemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
