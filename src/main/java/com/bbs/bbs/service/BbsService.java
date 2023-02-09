package com.bbs.bbs.service;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.repository.BbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BbsService {
    @Autowired
    private BbsRepository bbsRepository;


    //글 작성 처리
    public void Write(Bbs bbs) {
        bbsRepository.save(bbs);
    }

    //게시글 리스트 처리
    public List<Bbs> bbsList() {
        return bbsRepository.findAll();
    }

    //특정 게시글 불러오기
    public Bbs bbsView(Integer id) {
        return BbsRepository.findById(id).get();
    }
}
