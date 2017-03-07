import java.io.IOException;

public class Results {
	private static void alphabetiseArray(int word, int letter) {
		boolean done = false;
		String[] workAry = result;
		int count = workAry.length-1;
		int floor = 0;
//		int letter = 2;

		while(!done){
			int a =-1;
            int b =-1;
            
			

			if(count > floor){
				a = (int)Character.toUpperCase(workAry[count  ].split(" |	")[word].charAt(letter));
				b = (int)Character.toUpperCase(workAry[count-1].split(" |	")[word].charAt(letter));

				if(a<b){
					String cache = workAry[count-1];
					workAry[count-1] = workAry[count];
					workAry[count] = cache;
				}
				count--;	
			}else if(floor == workAry.length){
				if(letter > 0){
					letter--;
					floor = 0;
					count = workAry.length-1;
				
				}else{
					done = true;
				}
			}else{
				floor++;
				count = workAry.length-1;
			}
		}
			
		result = workAry;
	}
	

	public static void main(String[] args){
		result = ReadFileAsArray.readFile("marks.txt");
		
		alphabetiseArray(0,0);
		alphabetiseArray(1,1);
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
		
	}
	
	private static String[] result;
	
}


/*
https://www.amazon.co.uk/Bodum-COLUMBIA-Double-Walled-Stainless-Dishwasher/dp/B00005YY9X/ref=sr_1_1?ie=UTF8&qid=1487590308&sr=8-1&keywords=Bodum+Columbia

http://www.ebay.co.uk/itm/like/152370462725?lpid=122&chn=ps&adgroupid=13585920426&rlsatarget=pla-142405565586&adtype=pla&poi=&googleloc=1006897&device=c&campaignid=207297426&crdt=0

https://joybird.com/

http://www.coalesse.com/products/seating/lounge-chairs-sofas/hosu/
*/