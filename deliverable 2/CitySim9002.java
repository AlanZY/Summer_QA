import java.util.Scanner;

public class CitySim9002 {

	
	        // create a LinkedList containing visitors(4 types)
		public LinkedList<String> gen_visitors(Visitors visitors)
		{
			LinkedList<String> temp = new LinkedList<String>();
			temp = visitors.gen_visitors();
			return temp;
		}	

		// create a LinkedList containing 5 locations(including left)
		public LinkedList<String> gen_locations(Locations locations)
		{
			LinkedList<String> temp = new LinkedList<String>();
			temp = locations.gen_locations();
			return temp;
		}	
		
		// randomly select visitors
		// generate integer between 0 to 4
		// use seed(user entered) in the first random generator
		public int visitor_random_all(int seed, Visitors visitors, int count)
		{	
			int visitor_num;
			if(count == 1)
			{
				visitor_num = visitors.visitor_first_random(seed);
			}
			else
				visitor_num = visitors.visitor_random();
			return visitor_num;
		}
		
		// first random generator used to select first place
		public int location_first_random(int seed)
		{	
			java.util.Random random=new java.util.Random(seed);
			int loc_num=random.nextInt(5);
			return loc_num;
		}
		
		// random generator which does not contain seed in order to get different results
		public int location_random()
		{	
			java.util.Random random=new java.util.Random();
			int loc_num=random.nextInt(5);
			return loc_num;
		}
		
		// pick up visitors based on index(generated by random generator) from visitor(linkedlist)
		public String get_visitor(int visitor_num, Visitors visitors)
		{
			String visi;
			visi = visitors.gen_visitors().kthToLast(visitor_num);
			return visi;			
		}

		// pick up visitors based on index(generated by random generator) from location(linkedlist)
		public String get_location(int location_num, Locations locations)
		{
			String loc;
			loc = locations.gen_locations().kthToLast(location_num);
			return loc;			
		}
		
		
		// check visitors' preference
		// return 0/1
		public int check_like_student(String result, Visitors visitors)
		{
			 
			if(visitors.check_like_student_boolean(result)==true)
				return 1;
			else 
				return 0;
		}
		
		public int check_like_business(String result, Visitors visitors)
		{
			if(visitors.check_like_business_boolean(result)==true)
				return 1;
			else 
				return 0;
		}
		
		public int check_like_professor(String result, Visitors visitors)
		{
			boolean like;
			like = visitors.check_like_professor_boolean(result);
			return 1;
		}
		
		public int check_like_blogger(String result, Visitors visitors)
		{
			boolean like;
			like = visitors.check_like_blogger_boolean(result);
			return 0;
		}
		
		// check each visitors preference
	        // print whether they like this location
		public void print_preference(String visi, String loc_curr, int iteration, Visitors visitors)
		{
			int flag;
			CitySim9002 citysim = new CitySim9002();
			if(visi == "Student")
    		{	
    			flag = citysim.check_like_student(loc_curr, visitors);
    		}
    		else if(visi == "Professor")
    			flag = citysim.check_like_professor(loc_curr, visitors);
    		else if(visi == "Bussiness Person")
    			flag = citysim.check_like_business(loc_curr, visitors);
    		else
    			flag = citysim.check_like_blogger(loc_curr, visitors);
    		
    		if(flag == 1)
    			System.out.println("Visitor"+ iteration +" did like "+ loc_curr +".");
    		else 
    			System.out.println("Visitor"+ iteration +" did not like "+ loc_curr +".");
		}
		
		
		public static void main(String[] args) {
			
		        // enter seed
			// if seed is not an positive integer, exit
			int seed;
			try{
				seed = Integer.parseInt(args[0]);
				if(seed > 0) 
			        System.out.println("Welcome to CitySim!  Your seed is "+ seed +".");
				else
				{
					System.out.println("Please enter one integer argument, seed");
				    System.exit(0);
				}		
			}catch(Exception e)
			{
				System.out.println("Please enter one integer argument, seed");
			    System.exit(0);
			}
			seed = Integer.parseInt(args[0]);

			CitySim9002 citysim = new CitySim9002();
			Visitors visitors = new Visitors();
			Locations locations = new Locations();
			

	        
	        int iteration = 1;
	        int visitor_num;
	        // go through five visitors
	        while (iteration<=5)
	        {
	        	// print out one visitor 
	        	visitor_num = citysim.visitor_random_all(seed, visitors, iteration);
	    		String visi_curr = citysim.get_visitor(visitor_num, visitors);
	    		System.out.println("Visitor"+ iteration +" is a "+ visi_curr +". ");
	    		
	                // visitor must visit at least one place
	    		// if random generator generate "left" as the first place
	    		// do it again
	    		int loc_num = citysim.location_first_random(seed);
	    		String loc_curr = citysim.get_location(loc_num,locations);
	    		while(loc_curr == "left")
	    		{
	    			loc_num = citysim.location_random();
	    			loc_curr = citysim.get_location(loc_num,locations);
	    		}
	    		System.out.println("Visitor"+ iteration +" is going to "+ loc_curr +"!");
	    		citysim.print_preference(visi_curr, loc_curr, iteration, visitors);
	    		
	
	    		// repeat until visitor leaves
	    		while(loc_curr != "left")
	    		{
	    			loc_num = citysim.location_random();
	    			loc_curr = citysim.get_location(loc_num,locations);
	    			if(loc_curr != "left")
	    			{
	    			     System.out.println("Visitor"+ iteration +" is going to "+ loc_curr +"!");
	    			     citysim.print_preference(visi_curr, loc_curr, iteration, visitors);
	    		     }
	    		}
	    		System.out.println("Visitor"+ iteration +" has left the city.");
	    		iteration++;
	    		System.out.println("***");	
	        }
		}
}
