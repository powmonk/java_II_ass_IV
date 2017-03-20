import java.io.PrintStream;

public class Results {
	private static void swap(int pos1, int pos2){
		String cache = result[pos1];
		result[pos1] = result[pos2];
		result[pos2] = cache;
	}
	
	
	private static void alphabetiseArray(int word, int letter) {
		boolean done = false;
		int floor = 0;
		int count = result.length-1;

		while(!done){
			if(count > floor){
				int a = (int)(Character.toUpperCase(result[count  ].split(" |	")[word].charAt(letter)));
				int b = (int)(Character.toUpperCase(result[count-1].split(" |	")[word].charAt(letter)));

				if(a<b){
					swap(count-1, count);
				}
				count--;	
			}else if(floor == result.length){
				if(letter > 0){
					letter--;
					floor = 0;
					count = result.length-1;
				}else{
					done = true;
				}
			}else{
				floor++;
				count = result.length-1;
			}
		}
	}
	
	private static void swapPositions(int x, int y) {
		for(int i=0;i<result.length;i++){
			String[] loopArray = result[i].split(" |	");
			String cache = loopArray[0];
			loopArray[0] = loopArray[1];
			loopArray[1] = cache;
			result[i]="";
			for(int j=0;j<loopArray.length;j++){
				result[i]= result[i] + loopArray[j] + " ";
			}
		}
	}


	public static void main(String[] args){
			result = ReadFileAsArray.readFile("marks.txt");
			
			getMaxValues();
			
			alphabetiseArray(1,0);
			alphabetiseArray(0,2);
			
			swapPositions(0,1);
			
			String underline = String.valueOf((char)196);
			underline = underline + underline + underline + underline;
			
			output.printf("%-"+nameLng+"s%-10s\n", "Name", "Mark");			
			output.printf("%-"+nameLng+"s%-10s\n", underline, underline);		
			
			for(int i=0;i<result.length;i++){
				String[] tmp = result[i].split(" |	");
				output.printf("%-"+nameLng+"s%3s\n", tmp[0]+" "+tmp[1],tmp[2]);
			}
	}
	
	private static void getMaxValues() {
		for(int i=0;i<result.length;i++){
			String[] tmp = result[i].split(" |	");
			if(tmp[0].length()>initLng)
				initLng = tmp[0].length();
			
			if(tmp[1].length()>surLng)
				surLng = tmp[1].length();
		}
		nameLng = initLng + surLng;
	}

	private static int initLng = 0;
	private static int surLng = 0;
	private static int nameLng = 0;
	private static PrintStream output = new PrintStream(System.out);
	private static String[] result;
}