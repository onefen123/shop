package net.fen.shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/admin")
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "admin/index";
    }
}
