package com.bbs.bbs.service;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.repository.BbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BbsService {
    @Autowired
    private BbsRepository bbsRepository;

    private BbsService bbsService;

    public void Write(Bbs bbs) {
        bbsRepository.save(bbs);
    }

    public List<Bbs> bbsList() {
        return bbsRepository.findAll();
    }

}
