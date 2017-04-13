import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileAsArray {
	public static String[] readFileMethod(String fileName){
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader(fileName));
		}catch(FileNotFoundException fnfe){
			System.out.println("Error on opening file data");
			System.exit(2);
		}
		
		boolean done = false;
		String inputLine = null;
		int count = 0;
		String[] results = new String[0];
		
		while(!done){
			try{
				inputLine = reader.readLine();
			}catch(IOException ioe){
				System.out.println("I/O error");
				System.exit(3);
			}
			
			if(inputLine == null){
				done = true;
			}else{
				String[] temp = new String[results.length+1];
				System.arraycopy(results, 0, temp, 0, results.length);
				results = new String[temp.length];
				System.arraycopy(temp, 0, results, 0, temp.length);
				results[count] = inputLine;
				count++;
			}
		}
		
		try{
			reader.close();
		}catch(IOException ioe){
			System.out.println("Error closing file '"+fileName+"'");
			System.exit(4);
		}
		
		return results;
	}
	
	public static String[] readFile(String fileName){
		return readFileMethod(fileName);
	}
}
