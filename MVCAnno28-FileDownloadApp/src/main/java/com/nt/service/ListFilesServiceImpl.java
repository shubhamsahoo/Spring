package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("filesService")
public class ListFilesServiceImpl implements ListFilesService {

	@Override
	public List<String> getAllFiles(String storePath) {
		File fileStore=null;
		File content[]=null;
		List<String>  filesList=null;
		
		fileStore=new File(storePath);
		if(fileStore.exists()) {
			content=fileStore.listFiles();
			filesList=new ArrayList();
			for(File file:content) {
				if(file.isFile())
					filesList.add(file.getName());
			}//for
		}///if
		
		return filesList;
	}

}
