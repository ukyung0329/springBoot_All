package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.util.MediaTypeUtiles;

@RestController
public class FileController {
	
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadFile,
								HttpServletRequest req) {
		
		System.out.println("FileController fileUpload");
		
		// 경로
		String upLoadPath = req.getServletContext().getRealPath("/upload");
		
		// String upLoadPath = "d:\\tmp";
		
		String filename = uploadFile.getOriginalFilename();
		String filepath = upLoadPath + File.separator + filename;	//   '/'		
		System.out.println("filepath:" + filepath);
		
		// DB 접근
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			bos.write(uploadFile.getBytes());
			
			bos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "file upload fail";
		}
		
		return "file upload success";
	}
	
	@RequestMapping(value = "/download")
	public ResponseEntity<InputStreamResource> download(String fileName, HttpServletRequest req)throws IOException{
		
		System.out.println("FileController download");
		
		// 경로
		String upLoadPath = req.getServletContext().getRealPath("/upload");		
		// String upLoadPath = "d:\\tmp";
		
		MediaType mediaType = MediaTypeUtiles.getMediaTypeForFileName(this.servletContext, fileName);
		System.out.println("fileName:" + fileName);
		System.out.println("mediaType:" + mediaType);
		
		File file = new File(upLoadPath + File.separator + fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				.contentType(mediaType)
				.contentLength(file.length())
				.body(resource);	
	}
	
	
}








