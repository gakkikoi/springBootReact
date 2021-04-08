package com.yw.springboot.web;

import com.yw.springboot.domain.config.auth.LoginUser;
import com.yw.springboot.domain.config.auth.dto.SessionUser;
import com.yw.springboot.domain.user.User;
import com.yw.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts",postsService.PostsFindAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";

    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("post",postsService.findById(id));
        return "post-update";
    }



}
