package com.soch.Integra.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class APMUtils {
	
	public static void uploadCertDoc(String location,int solutionId,MultipartFile[] files)
	{
		System.out.println("solutionId "+solutionId);
		System.out.println("files "+files.length);
		location = location+"Solutions";
		File folder = new File(location+"Solutions");

		if (!folder.exists()) {
			folder.mkdir();
		}
		location = location+"/"+solutionId;
		folder = new File(location);
		if (!folder.exists()) {
			folder.mkdir();
		}
		String fileLoc = null;
		for (MultipartFile file : files) {

			File inputFile = new File(location);
			fileLoc = location + "/" + file.getOriginalFilename();
			inputFile = new File(fileLoc);

			try {
				file.transferTo(inputFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} finally {
				inputFile = null;
			}
		}
	}

}
