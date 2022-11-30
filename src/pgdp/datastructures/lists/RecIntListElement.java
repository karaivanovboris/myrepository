package pgdp.datastructures.lists;

public class RecIntListElement {
	private int value;
	private RecIntListElement next;
	private RecIntListElement prev;
	///////////////////////////////////////
	//private RecIntListElement prev2;
	//private RecIntListElement next2;
///////////////////////////////////
	public RecIntListElement(int value) {
		this(value, null);
	}

	public RecIntListElement(int value, RecIntListElement prev) {
		this.value = value;
		next = null;
		this.prev = prev;
		///////////////
		//next2=null;
		//this.prev2=prev;
	}
//_-_-_-_-_____-_-------__-_
	public RecIntListElement append(int value) {
		if (next != null) {
			return next.append(value);
		} else {
			next = new RecIntListElement(value, this);
			return next;
		}
	}
//-------------------->
	public int get(int idx) {
		if (idx == 0) {
			return value;
		}
		if (next == null) {
			System.out.println("Invalid index: list is to short!");
			return Integer.MIN_VALUE;
		}
		return next.get(idx - 1);
	}
//--------->
	public int size() {
		if (next == null) {
			return 1;
		}
		return 1 + next.size();
	}

	public boolean insert(int value, int idx) {
		if (idx < 0) {
			System.out.println("Cannot insert at negative index!");
			return false;
		}
		if (idx <= 1) {
			RecIntListElement n = new RecIntListElement(value, this);
			n.next = next;
			if (next != null) {
				next.prev = n;
			}
			next = n;
			if (idx == 0) {
				next.value = this.value;
				this.value = value;
			}
			return true;
		}
		if (next == null) {
			System.out.println("List is to short to insert at given index!");
			return false;
		}
		return next.insert(value, idx - 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		RecIntListElement tmp = this;
		do {
			sb.append(tmp.value).append(", ");
			tmp = tmp.next;
		} while (tmp != null);
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}

	public String toConnectionString() {
		StringBuilder sb = new StringBuilder();
		RecIntListElement tmp = this;
		do {
			if (tmp.prev != null) {
				sb.append("<-");
			}
			sb.append(tmp.value);
			if (tmp.next != null) {
				sb.append("->");
			}
			tmp = tmp.next;
		} while (tmp != null);
		return sb.toString();
	}
	///////////////////////////////////////

	public int getValue() {
		return value;
	}
	public void delete() {
		if (next != null)
			next = next.next;

	}

	public RecIntListElement getNext() {
		return next;
	}

	public void setNext(RecIntListElement next) {
		this.next = next;
	}

	public RecIntListElement getPrev() {
		return prev;
	}

	public void setPrev(RecIntListElement prev) {
		this.prev = prev;
	}
	public void zipp(RecIntListElement a,RecIntListElement b){

	}


	//////////////////////////////////////////////!!!!!!!!!
/*	public int get2(int idx) {
		if (idx == 0) {
			return value;
		}
		if (next == null) {
			System.out.println("Invalid index: list is to short!");
			return Integer.MIN_VALUE;
		}
		return next2.get2(idx - 1);
	}
	private RecIntListElement x=null;

	public void swish(RecIntListElement R){

		x=R.next;

		R.next=R.prev;

		R.prev=x;
	}


	public void setPrev2(RecIntListElement prev2) {
		this.prev2 = prev2;
	}

	public RecIntListElement getPrev2() {
		return prev2;
	}

	public void setNext2(RecIntListElement next2) {
		this.next2 = next2;
	}

	public RecIntListElement getNext2() {
		return next2;
	}

	public void setValue(int value) {
		this.value = value;
	}
	///////////////////!!!!!!!*/
}
