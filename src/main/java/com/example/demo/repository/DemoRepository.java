package com.example.demo.repository;

import com.example.demo.model.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<DemoModel, Long> {
}
