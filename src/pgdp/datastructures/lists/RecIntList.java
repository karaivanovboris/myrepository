package pgdp.datastructures.lists;

import java.util.Arrays;

public class RecIntList {
	private RecIntListElement head;

	public RecIntList() {
		head = null;
	}
	public void append(int value) {
		if (head == null) {
			head = new RecIntListElement(value);
		} else {
			head.append(value);
		}
	}

	public int get(int idx) {
		if (head == null) {
			System.out.println("Invalid index: list is empty!");
			return Integer.MAX_VALUE;
		}
		return head.get(idx);
	}

	public int size() {
	    /**
		 * can be rewritten as
		 * if(head==null)
		 * return 0;
		 * else
		 * return head.size();
		*/
		return head == null ? 0 : head.size();
	}

	public boolean insert(int value, int idx) {
		if (head == null) {
			if (idx == 0) {
				append(value);
				return true;
			} else {
				System.out.println("You may only insert at index 0 to a empty list!");
				return false;
			}
		}
		return head.insert(value, idx);
	}

	@Override
	public String toString() {
		if (head != null) {
			return "List: [" + head.toString() + "]";
		} else {
			return "Empty list";
		}
	}

	public String toConnectionString() {
		if (head != null) {
			return "List: [" + head.toConnectionString() + "]";
		} else {
			return "Empty list";
		}
	}
	private int i=0;
	private long kleiner=0;
	private long gleich=0;
	private long grosser=0;
	public long[] countThresh(int threshold) {
		// TODO
		if (size() == i) {
			long kleinerr = kleiner;
			long gleichh = gleich;
			long grosserr = grosser;
			i=0;
			kleiner = 0;
			gleich = 0;
			grosser = 0;
			return new long[]{kleinerr, gleichh, grosserr};
		}

		if (get(i) > threshold) {
			grosser += get(i);
		} else if (get(i) < threshold) {
			kleiner += get(i);
		} else {
			gleich += get(i);
		}

		i++;
			return countThresh(threshold);
		}

	private int previouss=0;
	private int g=0;
	public void kinguinSort(boolean increasing) {
		if (g+1>=size()){
			return;
		}
		if (g==0){
		previouss=getElement(g).getValue();
		g++;
		kinguinSort(increasing);
		}
		// TODO
		if(increasing){
			if (get(g)<previouss){
				getElement(g-1).delete();
				if (g+1<size()){
				getElement(g+1).setPrev(getElement(g));}
			}
			else{previouss=get(g);
				g++;}

			kinguinSort(increasing);
		}
		if(!increasing){
			if (get(g)>previouss){
				getElement(g-1).delete();
				if (g+1<size()){
					getElement(g+1).setPrev(getElement(g));}
				kinguinSort(increasing);
			}
			else{previouss=get(g);
				g++;}

			kinguinSort(increasing);
		}
	}
	private int m=0;

	public void reverse() {
		// TODO
		if(m==0){
			this.head=getElement(size()-1);
			m=size()-1;
		}

	}

	public static void zip(RecIntList l1, RecIntList l2) {
		// TODO
	}

	public static void main(String[] args) {
		// countThresh example
		RecIntList countThreshExample = new RecIntList();
		for (int i = 1; i <= 5; i++) {
			countThreshExample.append(i);
		}
		System.out.println(Arrays.toString(countThreshExample.countThresh(3)));


		// kinguinSort example (1)
		RecIntList kinguinSortExample = new RecIntList();
		int[] kinguinSortvalues = new int[] {2,4,7,3,21,2};
		for (int i : kinguinSortvalues) {
			kinguinSortExample.append(i);
		}
		kinguinSortExample.kinguinSort(false); // false for example (2)
		System.out.println(kinguinSortExample);



		// reverse example
		RecIntList reverseExample = new RecIntList();
		for (int i = 1; i < 6; i++) {
			reverseExample.append(i);
		}
		reverseExample.reverse();
		System.out.println(reverseExample);

		// zip example
		RecIntList l1 = new RecIntList();
		RecIntList l2 = new RecIntList();
		for (int i = 1; i <= 5; i += 2) {
			l1.append(i);
			l2.append(i + 1);
		}
		l1.append(7);
		l1.append(8);
		RecIntList.zip(l1, l2);
		System.out.println(l1);
	}
	///////////////////////

	private RecIntListElement getElement(int idx) {
		if (idx == 0) {
			return head;
		}
		return getElement(idx - 1).getNext();
	}
}
