package com.bbs.bbs.repository;

import com.bbs.bbs.entity.Bbs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Integer> { //JpaRepository<entity, pk type>
    Page<Bbs> findByTitleContaining(String searchKeyword, Pageable pageable);

}