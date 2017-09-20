package friends;

public class Person {
	String name; // the person's name
	Friend firstFriend; // the first friend in the list of this
						// person's friends
	Person nextPerson; // the next person in the list of people

	public Person(String name, Person nextPerson) {
		this.name = name;
		this.nextPerson = nextPerson;
	}

	// A string representing the list of friends of this person.
	// O(number of friends in the list)
	public String friendString() {
		StringBuilder sb = new StringBuilder();
		for (Friend fNode = firstFriend; fNode != null; fNode = fNode.nextFriend) {
			sb.append(fNode.who.name);
			sb.append(" ");
		}

		return sb.toString().trim();

	}

	// add friend as a friend of this person
	// O(1)
	public void addFriend(Person friend) {

		firstFriend = new Friend(friend, firstFriend);
	
	}

	// remove Person friend as a friend of this person
	// if friend is not a friend of this person, does nothing
	// O(number of friends of this person)
	public void removeFriend(Person friend) {
	
		// Variables needed for traversal
		Friend ptr = firstFriend;
		Friend prev = null;
		//handles if firstFriend is the friend that needs to be removed and single list
		if(firstFriend.nextFriend == null && firstFriend.who.name.equals(friend.name)){
			this.firstFriend = null;
		//case of match at front (first friend) in a two node list 
		}else if (firstFriend.who.name.equals(friend.name) && firstFriend.nextFriend != null){
			this.firstFriend = firstFriend.nextFriend;
		}else{
		while (ptr != null && !ptr.who.name.equals(friend.name)) {
			// traverse through friend list in search of match
			prev = ptr;
			ptr = ptr.nextFriend;
		}
		// case of match at last node
		if(ptr != null && ptr.nextFriend == null && ptr.who.name.equals(friend.name)){
			prev.nextFriend = null;
		}
		// case of match between two nodes
		if(ptr != null && ptr.who.name.equals(friend.name)){
			prev.nextFriend = ptr.nextFriend;
		}
		// gets to this point if ptr is null 
		}
		 
	}
}
