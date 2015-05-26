package com.FOEVERGOD73.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {
	String fileName;
	
	public WriteFile(String fileName){
		this.fileName = fileName;
	}

	public void WriteToFile(String content, boolean overWrite) {
		Writer writer = null;

		try {
			writer = new FileWriter(fileName, !overWrite);
			writer.write(content + "\n");
		} catch (IOException e) {
			System.err.println("Error writing the file : ");
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println("Error closing the file : ");
					e.printStackTrace();
				}
			}
		}
	}
}