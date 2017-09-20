package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {
	Person firstPerson; // First Person object in the list

	public PersonList() {
		this.firstPerson = null;
	}

	// finds Person object in this list with given name
	// if none exists, returns null. Runs in O(number of persons in this list)
	public Person lookup(String name) {
		// traverse person list here...
		for (Person Pnode = firstPerson; Pnode != null; Pnode = Pnode.nextPerson) {
			if (Pnode.name.equals(name)) {
				return Pnode;
			}
		}
		return null; // this occurs if we make it out of the list w/o finding
						// person

	}

	// creates a new Person object with name and adds it to the list of
	// Person objects. Runs in O(1)
	public Person addPerson(String name) {
		firstPerson = new Person(name, firstPerson);
		return firstPerson;
	}

}
