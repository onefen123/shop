package net.fen.shop.admin.controller;

import net.fen.shop.admin.entity.Brand;
import net.fen.shop.admin.utils.FileController;
import net.fen.shop.admin.utils.Jsondata;
import net.fen.shop.admin.utils.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/brand")
public class BrandController {

    @Autowired
    Upload upload;

    @RequestMapping("/lst")
    public String list(){
        return "admin/brand/lst";
    }

    @RequestMapping("/add")
    public String add(){
        return "admin/brand/add";
    }


    @RequestMapping("/add_post")
    public Jsondata add_post( @RequestParam("logo") MultipartFile file, HttpServletRequest request){
//        Upload upload=new Upload();
        Jsondata jsondata=upload.upload(file,request);

            return jsondata;



    }

    @RequestMapping("/edit")
    public String edit(){
        return "admin/brand/edit";
    }

    @RequestMapping("/del")
    public String del(){
        return "admin/brand/del";
    }
}
