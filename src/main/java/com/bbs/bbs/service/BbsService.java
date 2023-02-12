package com.bbs.bbs.service;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.repository.BbsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BbsService {
    @Autowired
    private final BbsRepository bbsRepository;


    //글 작성 처리
    public void write(Bbs bbs) {
        bbsRepository.save(bbs);
    }

    //게시글 리스트 처리
    public List<Bbs> bbsList() {
        return bbsRepository.findAll();
    }

    //특정 게시글 불러오기
    public Bbs bbsView(Integer id) {
        return bbsRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void bbsDelete(Integer id) {
        bbsRepository.deleteById(id);
    }
}
