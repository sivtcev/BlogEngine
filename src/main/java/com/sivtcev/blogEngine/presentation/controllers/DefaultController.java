package com.sivtcev.blogEngine.presentation.controllers;

import com.sivtcev.blogEngine.presentation.api.response.InitResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class DefaultController {
    private final InitResponse initResponse;

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
