package com.kosta.di.sample2;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutPutter implements Outputter {
	private String filePath;
	
	public FileOutPutter(String filePath){
		this.filePath = filePath;
		
	}

	@Override
	public void output(String message) throws IOException {
		FileWriter writer = new FileWriter(filePath);
		writer.write(message);
		writer.close();

	}

}
