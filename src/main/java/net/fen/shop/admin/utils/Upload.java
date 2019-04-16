package net.fen.shop.admin.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@PropertySource({"classpath:application.yml"})
public class Upload {
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    String folder=df.format(new Date());

    private static final String filepath="d:/Upload/";
    private final String filepath2=filepath + folder + "/";



    @Value("${web.Upload-path}")
    private String filepath1;
    @RequestMapping(value = "/upload")
    public Object upload(MultipartFile file, HttpServletRequest request){

        file.isEmpty();//判断是否空
        file.getSize();//判断字体大小


        File filee=new File(filepath2);
        if(!filee.exists()){
            filee.mkdirs();
        }

        String filename=file.getOriginalFilename();//获取原始文件名
        String suffixname=filename.substring(filename.lastIndexOf("."));//获取扩展名
        filename= System.currentTimeMillis()+suffixname; //获取上传后的文件名

        File dest=new File(filepath2 + filename);
        try {
            file.transferTo(dest);
            return new Jsondata(1,"successfully!",folder+"/"+filename);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Jsondata(1,"Upload failed!");
    }
}
