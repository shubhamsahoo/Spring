package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UploadCommand;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="/upload.htm",method = RequestMethod.GET)
	public   String  showForm(@ModelAttribute("uplCmd") UploadCommand cmd) {
		return  "upload_form";
	}
	
	
	@RequestMapping(value="/upload.htm",method = RequestMethod.POST)
	public  String    upload(HttpServletRequest req,Map<String,Object> map, @ModelAttribute("uplCmd") UploadCommand cmd)throws Exception {
		ServletContext sc=null;
		String uplFolder=null;
		File file=null;
		String fname1=null,fname2=null;
		InputStream  is1=null,is2=null; 
		OutputStream  os1=null,os2=null;
		//get SErvletContext obj
		sc=req.getServletContext();
		//read context param value
		uplFolder=sc.getInitParameter("uploadFolder");
		//create or locate folder
		file=new File(uplFolder);
		if(!file.exists())
			  file.mkdir();
		//get the name of uploaded files..
		fname1=cmd.getFile1().getOriginalFilename();
		fname2=cmd.getFile2().getOriginalFilename();
		//create InputStream pointing  to uploaded files.. 
		is1=cmd.getFile1().getInputStream();
		is2=cmd.getFile2().getInputStream();
		//create OutputStreams pointing to dest files (empty)..
		os1=new FileOutputStream(file.getAbsolutePath()+"/"+fname1);
		os2=new FileOutputStream(file.getAbsolutePath()+"/"+fname2);
		
		//perform file copy activitity
		IOUtils.copy(is1, os1);
		IOUtils.copy(is2, os2);
		
		//add the uploaded file names as model Attributes
		map.put("fname1",fname1);
		map.put("fname2",fname2);
		
		//close streams
		is1.close();
		is2.close();
		os1.close();
		os2.close();
		
		return "result";
	}
	

}
