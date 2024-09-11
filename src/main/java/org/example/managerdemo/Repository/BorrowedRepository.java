package org.example.managerdemo.Repository;

import org.example.managerdemo.Entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedRepository extends JpaRepository<Borrowing, Integer> {
}
