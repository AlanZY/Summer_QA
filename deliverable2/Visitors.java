


public class Visitors {
Node<String> _head = null;
	
    // create a visitors linkedlist
	public LinkedList<String> gen_visitors()
	{
		LinkedList<String> visitors = new LinkedList<String>();
		Node<String> blogger = new Node<String>("Blogger");
		Node<String> professor = new Node<String>("Professor");
		Node<String> business = new Node<String>("Bussiness Person");
		Node<String> student = new Node<String>("Student");
		visitors.addToEnd(student);
		visitors.addToEnd(business);
		visitors.addToEnd(professor);
		visitors.addToEnd(blogger);
		return visitors;
	}
	
	// random generator(containing seed)
	public int visitor_first_random(int seed)
	{	
		java.util.Random random=new java.util.Random(seed);
		int visitor_num=random.nextInt(4);
		return visitor_num;
	}

	// random generator(do not contain seed)
	public int visitor_random()
	{	
		java.util.Random random=new java.util.Random();
		int visitor_num=random.nextInt(4);
		return visitor_num;
	}
	
	 // used to select item from linkedlist randomly
	 public String kthToLast(int k) {
			if (_head == null) {
				return null;
			}
			Node<String> ptr = _head;
			Node<String> candidate = null;
			int ctr = 0;
			while (ptr != null) {
				
				if (ctr == k) {
					candidate = _head;
				} else if (ctr > k) {
					candidate = candidate.getNext();
				}
				ctr++;
				ptr = ptr.getNext();
			}
			if (candidate == null) {
				return null;
			} else {
				return candidate.getData();
			}
		}
	
	 // used to form a linkedlist
	 public void addToEnd(Node<String> toAdd) {
			toAdd.setNext(null);
			
			if (_head == null)
			{
				_head = toAdd;
			} 
			else 
			{
				Node<String> ptr = _head;
				Node<String> last = ptr;
				while (ptr != null) 
				{
					
					last = ptr;
					ptr = ptr.getNext();
				}
				
				last.setNext(toAdd);	
			}
		
		}
	
		// print linkedlist
		public void prettyPrint() {
			
			Node<String> ptr = _head;
			if (_head == null) {
				System.out.println("<NULL>");
			}
			while (ptr != null) {
				if (ptr.getNext() != null) {
					System.out.print(ptr.getData() + " -> ");
				}  else {
					System.out.println(ptr.getData());
				}
				ptr = ptr.getNext();
			}
		}
		
	    // check visitors' preference
		// return boolean
		public boolean check_like_business_boolean(String result)
		{
			boolean like = true;
			if(result == "The Point")
				like = false;
			if(result == "The Cathedral of Learning")
				like = false;
			return like;
		}
		
		public boolean check_like_blogger_boolean(String result)
		{
			boolean like = false;
			return like;
		}
		
		public boolean check_like_student_boolean(String result)
		{
			boolean like = true;
			if(result == "The Cathedral of Learning")
				like = false;
			return like;
		}
	 
		public boolean check_like_professor_boolean(String result)
		{
			boolean like = true;
			return like;
		}

	 
	
}
