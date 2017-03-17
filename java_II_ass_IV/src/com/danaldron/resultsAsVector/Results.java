package com.danaldron.resultsAsVector;
import java.io.IOException;

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

	public static void main(String[] args){
		result = ReadFileAsVector.readFile("marks.txt");
		
		alphabetiseArray(0,0);
		alphabetiseArray(1,2);
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	private static String[] result;
}