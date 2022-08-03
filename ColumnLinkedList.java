package projects.sparse_matrix;

public class ColumnLinkedList {

	private ColumnNode head;
	private ColumnNode tail;
	private int length;
	private int columns;

	public ColumnLinkedList(int columns) {
		this.columns = columns;
	}

	private boolean isEmpty() {
		return (length < 1);
	}

	private ColumnNode getHead() {
		return this.head;
	}

	private ColumnNode getTail() {
		return this.tail;
	}

	private void link(ColumnNode first, ColumnNode second) {
		if (first != null)
			first.setNext(second);
		if (second != null)
			second.setPrevious(first);
	}

	private void insertFirst(int value, int column) {
		ColumnNode newNode_SparseArray = new ColumnNode(value, column);
		if (isEmpty()) {
			tail = newNode_SparseArray;
		} else {
			link(newNode_SparseArray, head);
		}
		head = newNode_SparseArray;
		length++;
	}

	private void insertLast(int value, int column) {
		ColumnNode newNode_SparseArray = new ColumnNode(value, column);
		if (isEmpty()) {
			head = newNode_SparseArray;
		} else {
			link(tail, newNode_SparseArray);
		}
		tail = newNode_SparseArray;
		length++;
	}

	private void empedAfter(ColumnNode before, int value, int column) {
		ColumnNode newNode_SparseArray = new ColumnNode(value, column);
		ColumnNode after = before.getNext();

		link(before, newNode_SparseArray);
		link(newNode_SparseArray, after);
		length++;
	}

	private void insertSorted(int value, int column) {
		if (isEmpty() || head.getcolumn() > column) {
			insertFirst(value, column);
		} else if (tail.getcolumn() < column) {
			insertLast(value, column);
		} else {
			for (ColumnNode cur = head; cur != null; cur = cur.getNext()) {
				if (cur.getcolumn() > column) {
					empedAfter(cur.getPrevious(), value, column);
					break;
				} else if (cur.getcolumn() == column) {
					cur.setvalue(value);
					break;
				}

			}

		}
	}

	public void setValue(int value, int column) {
		insertSorted(value, column);
	}

	public int getValue(int column) {
		if (!isEmpty()) {
			for (ColumnNode cur = head; cur != null; cur = cur.getNext()) {
				if (cur.getcolumn() == column)
					return cur.getvalue();
			}
		}
		return -1;
	}

	public void printArray() {
		int temp = 0;
		for (ColumnNode cur = head; temp < columns;) {
			if (cur == null || cur.getcolumn() != temp) {
				System.out.print(0 + " ");
			} else {
				System.out.print(cur.getvalue() + " ");
				cur = cur.getNext();
			}
			temp++;
		}
		System.out.println();
	}

	public void printArrayNonZero() {
		for (ColumnNode cur = head; cur != null; cur = cur.getNext()) {
			System.out.print(cur.getvalue() + " ");
		}
	}

	private void merge_2SortedSparseArrays(ColumnLinkedList l1) { // o(n+m) time, where n length of first list and m
																	// length of second list
		ColumnNode newHead = null, next = null, cur1 = head, cur2 = l1.getHead();
		while (cur1 != null && cur2 != null) {
			if (cur1.getcolumn() == cur2.getcolumn()) {
				cur1.setvalue(cur1.getvalue() + cur2.getvalue());
				link(next, cur1);
				next = cur1;
				cur1 = cur1.getNext();
				cur2 = cur2.getNext();
				length--;
			} else if (cur1.getcolumn() < cur2.getcolumn()) {
				if (newHead == null) {
					newHead = cur1;
				} else {
					link(next, cur1);
				}
				next = cur1;
				cur1 = cur1.getNext();

			} else {
				if (newHead == null) {
					newHead = cur2;
				} else {
					link(next, cur2);
				}
				next = cur2;
				cur2 = cur2.getNext();
			}
			length += l1.length;
		}
		head = newHead;
		if (cur1 == null) {
			link(next, cur2);
			tail = l1.getTail();
		} else {
			link(next, cur1);
		}
	}

	public void add(ColumnLinkedList arr1) {
		merge_2SortedSparseArrays(arr1);
	}
}
