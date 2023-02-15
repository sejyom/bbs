package com.bbs.bbs.controller;

import com.bbs.bbs.entity.Bbs;
import com.bbs.bbs.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/bbs/write") //어떤 url로 접근할 건지 지정 (localhost:8080/bbs/write)
    public String bbsWriteForm() {
        return "bbswrite";
    }

    @PostMapping("/bbs/writepro") //글쓰기 처리
    public String bbsWritePro(Bbs bbs, Model model, MultipartFile file) throws Exception {
        bbsService.write(bbs, file);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/bbs/list");
        return "message";
    }

    @GetMapping("/bbs/list")
    public String bbsList(Model model) {
        model.addAttribute("list", bbsService.bbsList());
        return "bbslist";
    }

    @GetMapping("/bbs/view") //localhost:8080/bbs/view?id=1
    public String bbsView(Model model, Integer id) {
        model.addAttribute("bbs", bbsService.bbsView(id));
        return "bbsview";
    }

    @GetMapping("/bbs/delete")
    public String bbsDelete(Integer id) {
        bbsService.bbsDelete(id);
        return "redirect:/bbs/list";
    }

    @GetMapping("/bbs/modify/{id}")
    public String bbsModify(@PathVariable("id") Integer id, Model model) {
        //PathVariable: 중괄호 안의 id가 Integer 형태의 id로 들어옴

        model.addAttribute("bbs", bbsService.bbsView(id));
        return "bbsmodify";
    }

    @PostMapping("/bbs/update/{id}")
    public String bbsUpdate(@PathVariable("id") Integer id, Bbs bbs, Model model, MultipartFile file) throws Exception {
        Bbs bbsTemp = bbsService.bbsView(id); //임의의 객체에 기존 데이터 가져와서
        bbsTemp.setTitle(bbs.getTitle()); //새로 입력된 데이터로 덮어씌움
        bbsTemp.setContent(bbs.getContent());

        bbsService.write(bbsTemp, file);

        model.addAttribute("message", "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/bbs/list");

        return "message";
    }

}
