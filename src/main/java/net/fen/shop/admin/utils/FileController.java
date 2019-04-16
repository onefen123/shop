package net.fen.shop.admin.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	@Value("${image.location.path}")
	private String resourceDir;

	@RequestMapping(value = "/file/oneFileUpload", method = RequestMethod.POST)
	// 上传文件
	public Jsondata oneFileUpload(MultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			String oneFileUpload = FileUpload(file);
			return new Jsondata(1,"Upload failed!");
		} else {
			return new Jsondata(1,"Upload failed!");
		}
	}

	public String FileUpload(MultipartFile file)  {
		// 获取上传文件路径
		String uploadPath = file.getOriginalFilename();
		// 获取上传文件的后缀
		String fileSuffix = uploadPath.substring(uploadPath.lastIndexOf(".") + 1, uploadPath.length());
		// 上传目录地址
		uploadPath = resourceDir;
		// 上传文件名
		String fileName = new Date().getTime() + new Random().nextInt(100) + "." + fileSuffix;
		File savefile = new File(uploadPath  + fileName);
		if (!savefile.getParentFile().exists()) {
			savefile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(savefile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/image/"  + fileName;
	}

}
