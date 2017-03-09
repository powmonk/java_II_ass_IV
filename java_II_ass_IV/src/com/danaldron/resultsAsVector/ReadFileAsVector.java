package com.danaldron.resultsAsVector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class ReadFileAsVector {
	public static Vector<String> readFileMethod(String fileName){
		BufferedReader reader = null;
		Vector<String> wordList = new Vector<String>();
		
		try{
			reader = new BufferedReader(new FileReader(fileName));
		}catch(FileNotFoundException fnfe){
			System.out.println("Error on opening file data");
			System.exit(1);
		}
		
		boolean done = false;
		String inputLine = null;
		
		while(!done){
			try{
				inputLine = reader.readLine();
			}catch(IOException ioe){
				System.out.println("I/O error");
				System.exit(2);
			}
			if(inputLine == null){
				done = true;
			}else{
				wordList.add(inputLine);
			}
		}
		try{
			reader.close();
		}catch(IOException ioe){
			System.out.println("Error closing file '"+fileName+"'");
			System.exit(3);
		}
		
		return wordList;
	}
	
	public static Vector<String> readFile(String fileName){
		return readFileMethod(fileName);
		
	}
}
