package com.bbs.bbs.service;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.repository.BbsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BbsService {
    @Autowired
    private final BbsRepository bbsRepository;


    //글 작성 처리
    public void write(Bbs bbs, MultipartFile file) throws Exception { //MultipartFile 파일 처리
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files"; //projectPath에 프로젝트 경로가 담김
        UUID uuid = UUID.randomUUID(); //랜덤 식별자
        String fileName = uuid + "_" + file.getOriginalFilename(); //fileName = 랜덤 식별자(uuid) + _ + 원파일명
        File saveFile = new File(projectPath, fileName); //파일 객체를 생성해서 projectPath(경로)에 fileName(파일명)으로 넣어줌

        file.transferTo(saveFile); //파일 저장

        bbs.setFilename(fileName);
        bbs.setFilepath("/files/" + fileName);

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
