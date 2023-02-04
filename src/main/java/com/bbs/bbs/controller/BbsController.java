package com.bbs.bbs.controller;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BbsController {

    @Autowired
    private BbsService bbsService;
    @GetMapping("/bbs/write") //어떤 url로 접근할 건지 지정 (localhost:8080/bbs/write)
    public String bbsWriteForm() {
        return "bbswrite";
    }

    @PostMapping("/bbs/writepro")
    public String bbsWritePro(Bbs bbs) {
        bbsService.Write(bbs);
        return "";
    }
}
