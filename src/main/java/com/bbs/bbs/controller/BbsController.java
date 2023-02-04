package com.bbs.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BbsController {
    @GetMapping("/bbs/write") //어떤 url로 접근할 건지 지정 (localhost:8080/bbs/write)
    public String bbsWriteForm() {
        return "bbswrite";
    }
}
