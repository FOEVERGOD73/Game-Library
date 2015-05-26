package com.GameEngine.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	File file;
	FileReader fileReader;
	String fileName;
	public ReadFile(String fileName){
		this.fileName = fileName;
	}
	public float ReadFromFileF(){
		String valueString = null;
		file = new File(fileName);
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bfileReader = new BufferedReader(fileReader);
		try {
			valueString = bfileReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		float value = Float.parseFloat(valueString);
		return value;
	}
	public String ReadFromFileS(){
		String value = null;
		file = new File(fileName);
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bfileReader = new BufferedReader(fileReader);
		try {
			value = bfileReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
