
public class Results {
	private static void alphabetiseArray() {
		boolean done = false;
		String[] workAry = result;
		int count = workAry.length-1;
		int floor = 0;
		int word = 1;
		int letter = 0;

		while(!done){
			if(count > floor){
				int a = (int)Character.toUpperCase(workAry[count].split(" |	")[word].charAt(letter));
				int b = (int)Character.toUpperCase(workAry[count-1].split(" |	")[word].charAt(letter));
				
				if(a<b){
//					System.out.println("comparison hit");
					String cache = workAry[count-1];
					workAry[count-1] = workAry[count];
					workAry[count] = cache;
				}
				
				count--;	
			}else if(floor == workAry.length){
				if(word == 0){
					word = 1;
					letter = 1;
					floor = 0;
					count = workAry.length-1;
				
				}else{
					done = true;
				}
//				done = true;
			}else{
				floor++;
				count = workAry.length-1;
			}
		}
		result = workAry;
	}
	

	public static void main(String[] args){
		result = ReadFileAsArray.readFile("marks.txt");
		
		alphabetiseArray();
		
		for(int i=0;i<result.length;i++){
			//System.out.println((int)Character.toUpperCase(result[i].split(" |	")[1].charAt(0)));
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