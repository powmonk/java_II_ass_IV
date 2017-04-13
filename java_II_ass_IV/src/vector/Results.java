import java.io.PrintStream;
import java.util.Vector;

public class Results {

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Usage: java Results <filename>");
			System.exit(1);
		}

		result = ReadFileAsVector.readFile(args[0]);
		
		getMaxValues();
		
		result.sort(null);
		
		String underline = String.valueOf((char)196);
		underline = underline + underline + underline + underline;
		
		output.printf("%-"+nameLng+"s%-10s\n", "Name", "Mark");			
		output.printf("%-"+nameLng+"s%-10s\n", underline, underline);		
		
		for(int i=0;i<result.size();i++){
			String[] tmp = result.get(i).split("\\s+");
			output.printf("%-"+nameLng+"s%3s\n", tmp[1] +" "+ tmp[0], tmp[2]);
		}
	}
	
	private static void getMaxValues() {
		for(int i=0;i<result.size();i++){
			String[] tmp = result.get(i).split("\\s+");
			if(tmp[0].length()>surLng)
				surLng = tmp[0].length();
			if(tmp[1].length()>initLng)
				initLng = tmp[1].length();
		}
		nameLng = initLng + surLng;
	}

	private static int initLng = 0;
	private static int surLng = 0;
	private static int nameLng = 0;
	private static PrintStream output = new PrintStream(System.out);
	private static Vector<String> result;
}