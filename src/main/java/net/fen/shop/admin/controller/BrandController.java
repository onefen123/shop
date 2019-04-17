package net.fen.shop.admin.controller;


import net.fen.shop.admin.entity.Brand;
import net.fen.shop.admin.service.BrandService;
import net.fen.shop.admin.utils.Fileupload;
import net.fen.shop.admin.utils.Jsondata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    @RequestMapping("/lst")
//    @ResponseBody
    public String list(Model model){
        List<Brand> lists=new ArrayList<>();
        lists=brandService.selectall_brand();
        model.addAttribute("lists",lists);
//        return list;
        return "admin/brand/lst";
    }

    @RequestMapping("/add")
    public String add(){
            return "admin/brand/add";
    }


    @RequestMapping("/add_post")
    public String add_post(@RequestParam(value = "logo") MultipartFile file, HttpServletRequest request, Model model){

        Brand brand=new Brand();
        Fileupload fileupload=new Fileupload();
        Jsondata jsondata=fileupload.upload(file);

        if ((jsondata.getCode())==1){
            brand.setName(request.getParameter("name"));
            brand.setLogo(jsondata.getMsg());
            brand.setDescription(request.getParameter("description"));
            brand.setUrl(request.getParameter("url"));
            brandService.add_brand(brand);
            return "admin/brand/add";
        }else {
            Map<String,String> map=new HashMap<>();
            map.put("name","上传文件失败!!");
            model.addAttribute("error",map);
            return "admin/error";
        }










    }

    @RequestMapping("/edit")
    public String edit(){
        return "admin/brand/edit";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id,Model model){
        int res=brandService.del(id);
        if(res==1){
            Map<String,String> map=new HashMap<>();
            map.put("name","删除成功!!");
            model.addAttribute("error",map);
            return "admin/error";
        }else {
            brandService.del(id);
            Map<String,String> map=new HashMap<>();
            map.put("name","删除失败!!");
            model.addAttribute("error",map);
            return "admin/error";
        }

    }
    @RequestMapping("/edit/brand/{id}")
    public String edit(@PathVariable int id,Model model){
        Brand brand=brandService.selectById(id);
        model.addAttribute("brand",brand);
        return "admin/brand/edit";
    }
    @RequestMapping("/del/{id}")
    public String edit_post(@RequestParam(value = "logo") MultipartFile file,HttpServletRequest request,Model model){
//        Brand brand=new Brand();
//        Fileupload fileupload=new Fileupload();
//        Jsondata jsondata=fileupload.upload(file);
//
//        brand.setName(request.getParameter("name"));
//        brand.setLogo(jsondata.getMsg());
//        brand.setDescription(request.getParameter("description"));
//        brand.setUrl(request.getParameter("url"));
//        brandService.add_brand(brand);

        return "admin/error";
    }


}
