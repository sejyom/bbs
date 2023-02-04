package com.bbs.bbs.repository;

import com.bbs.bbs.entity.Bbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Integer> { //JpaRepository<entity, pk type>

}
