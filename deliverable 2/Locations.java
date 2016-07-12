

public class Locations {
	
	Node<String> _head = null;
	LinkedList<String> locations = new LinkedList<String>();
	
	// create a location linkedlist
	public LinkedList<String> gen_locations()
	{
		LinkedList<String> locations = new LinkedList<String>();
		Node<String> cathdral = new Node<String>("The Cathedral of Learning");
		Node<String> squirhill = new Node<String>("Squirrel Hill");
		Node<String> point = new Node<String>("The Point");
		Node<String> downtown = new Node<String>("Downtown");
		Node<String> left = new Node<String>("left");
		locations.addToEnd(left);	
		locations.addToEnd(downtown);
		locations.addToEnd(point);
		locations.addToEnd(squirhill);
		locations.addToEnd(cathdral);
		return locations;
	}

	// get location based on kthToLast
	public String get_location(int loc_num, Locations locations)
	{
		String loc;
		loc = locations.kthToLast(loc_num);
		return loc;			
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
		
}
