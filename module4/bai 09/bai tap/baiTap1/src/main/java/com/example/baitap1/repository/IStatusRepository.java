package com.example.baitap1.repository;

import com.example.baitap1.entity.Code;
import com.example.baitap1.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository  extends JpaRepository<Status,Integer> {
}
