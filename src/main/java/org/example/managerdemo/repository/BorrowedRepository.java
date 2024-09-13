package org.example.managerdemo.repository;

import org.example.managerdemo.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedRepository extends JpaRepository<Borrowing, Integer> {
}
