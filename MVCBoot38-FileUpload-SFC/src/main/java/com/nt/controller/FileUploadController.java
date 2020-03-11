package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nt.command.UploadCommand;

@Controller
public class FileUploadController {
	
	@GetMapping("/upload.htm")
	public String  showForm(@ModelAttribute("uplCmd") UploadCommand cmd) {
		return "upload_form";
	}
	
	
	@PostMapping("/upload.htm")
	public    String  uploadFiles(Map<String,Object> map,
			                                             @ModelAttribute("uplCmd") UploadCommand cmd) throws Exception{
		MultipartFile file1=null,file2=null;
		String filename1=null, filename2=null;
		String folderStore="E:/Store";
		File file=null;
		InputStream is1=null,is2=null;
		OutputStream os1=null,os2=null;
		//get the uploadfiles from Command class obj 
		file1=cmd.getFile1();
		file2=cmd.getFile2();
		// get original filenames of the uploaded files
		filename1=file1.getOriginalFilename();
		filename2=file2.getOriginalFilename();
		//create Destination folder to save the upploaded files
		file=new File(folderStore);
		if(!file.exists())
			 file.mkdir();
		//create InputSteams pointing to uploaded files
		is1=file1.getInputStream();
		is2=file2.getInputStream();
		//create OutputStream pointing to empty destination files
		os1=new FileOutputStream(folderStore+"/"+filename1);
		os2=new FileOutputStream(folderStore+"/"+filename2);
		//perform file copy operation using io streams
		IOUtils.copy(is1,os1);
		IOUtils.copy(is2,os2);
		//close the steams
		is1.close(); is2.close();
		os1.close(); os2.close();
		//add model attributes
		map.put("fname1",filename1+" "+file1.getSize()+" bytes");
		map.put("fname2",filename2+""+file2.getSize()+"bytes");
		
		return "result";
	}

}
