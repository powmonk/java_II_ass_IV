import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileAsArray {
	public static ArrayList<String> readFileMethod(String fileName){
		BufferedReader reader = null;
		ArrayList<String> wordList = new ArrayList<String>();
		
		try{
			reader = new BufferedReader(new FileReader(fileName));
		}catch(FileNotFoundException fnfe){
			System.out.println("Error on opening file data");
			System.exit(1);
		}
		
		boolean done = false;
		String inputLine = null;
		
		int count = 0;
		
		//this loop counts the number of lines in the file to create the array
		while(!done){
			try{
				reader.readLine();
				count++;
			}catch(IOException ioe){
				System.out.println("I/O error");
				System.exit(2);
			}
			if(inputLine == null){
				done = true;
			}
		}
		
		String[] names = new String[count];

		
		
		try{
			reader.close();
		}catch(IOException ioe){
			System.out.println("Error closing file '"+fileName+"'");
			System.exit(3);
		}
		
		return wordList;
	}
	
	public static ArrayList<String> readFile(String fileName){
		return readFileMethod(fileName);
		
	}
}
