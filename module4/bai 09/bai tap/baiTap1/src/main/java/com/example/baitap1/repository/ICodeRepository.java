package com.example.baitap1.repository;

import com.example.baitap1.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICodeRepository extends JpaRepository<Code,Integer> {
    List<Code>findCodeByBook_Id(Integer id);
    List<Code>findCodeByBook_IdAndStatus_Id(Integer bookId,Integer statusId);
}
