package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.ListFilesService;

@Controller
public class FileDownalodOperationsController {
	@Autowired
	private  ListFilesService service;
	
	
	@RequestMapping("/list_files.htm")
	public  String    showFilesPage(HttpServletRequest req,Map<String,Object> map) {
		List<String> filesList=null;
		String  fileStore=null;
		//get Context Param value
		fileStore=req.getServletContext().getInitParameter("uploadStore");
		//use service
		filesList=service.getAllFiles(fileStore);
		//put result in map
		map.put("filesList", filesList);
		return "show_files_page";
	}
	
	@RequestMapping("/download.htm")
	public  void  download(@RequestParam("fileName") String fname,
			                                      HttpServletRequest req,
			                                      HttpServletResponse res)throws Exception{
		ServletContext sc=null;
		File file=null;
		InputStream is=null;
		OutputStream os=null;
		//get ServletContext object
		sc=req.getServletContext();
		//Locate the file to be downloaded
		file=new File(sc.getInitParameter("uploadStore")+"/"+fname);
		//get lengh of the file and make it response content  length
		res.setContentLengthLong(file.length());
		//get MIME of the file  and make it response MIME type
		res.setContentType(sc.getMimeType(sc.getInitParameter("uploadStore")+"/"+fname));
		// create Input Stream pointing to the file
		is=new FileInputStream(file);
		//create OuputStream pointing to response obj
		os=res.getOutputStream();
		//give instruction browser to make the recieved content of as downloadable file
		res.addHeader("Content-Disposition","attachment;fileName="+fname);
		//write the content of file to be downloaded to response object
		IOUtils.copy(is,os);
		//close streams
		is.close();
		os.close();
		
		//return ;
		
		
	}

}
