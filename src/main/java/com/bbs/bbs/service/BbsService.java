package com.bbs.bbs.service;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.repository.BbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
    @Autowired
    private BbsRepository bbsRepository;
    public void Write(Bbs bbs) {
        bbsRepository.save(bbs);
    }
}
