package projects.sparse_matrix;

public class SparseMatrix {

	private RowNode head;
	private RowNode tail;
	private int length;
	private int rows;
	private int cols;

	public SparseMatrix(int rows, int cols) {
		this.cols = cols;
		this.rows = rows;
		length = 0;
	}

	public int getLength() {
		return this.length;
	}

	public boolean isEmpty() {
		return (length < 1);
	}

	public RowNode getHead() {
		return this.head;
	}

	public RowNode getTail() {
		return this.tail;
	}

	private void link(RowNode first, RowNode second) {
		if (first != null)
			first.setNext(second);
		if (second != null)
			second.setPrevious(first);
	}

	private void insertFirst(int value, int row, int col) {
		RowNode newRow = new RowNode(row, cols);
		newRow.setvalue(value, col);
		if (isEmpty()) {
			tail = newRow;
		} else {
			link(newRow, head);
		}
		head = newRow;
		length++;
	}

	private void insertLast(int value, int row, int col) {
		RowNode newRow = new RowNode(row, cols);
		newRow.setvalue(value, col);
		if (isEmpty()) {
			head = newRow;
		} else {
			link(tail, newRow);
		}
		tail = newRow;
		length++;
	}

	private void empedAfter(RowNode before, int value, int row, int col) {
		RowNode newRow = new RowNode(row, cols);
		newRow.setvalue(value, col);
		RowNode after = before.getNext();

		link(before, newRow);
		link(newRow, after);
		length++;
	}

	private void insertSorted(int value, int row, int col) {
		if (isEmpty() || head.getrow() > row) {
			insertFirst(value, row, col);
		} else if (tail.getrow() < row) {
			insertLast(value, row, col);
		} else {
			for (RowNode cur = head; cur != null; cur = cur.getNext()) {
				if (cur.getrow() > row) {
					empedAfter(cur.getPrevious(), value, row, col);
					break;
				} else if (cur.getrow() == row) {
					cur.setvalue(value, col);
					break;
				}

			}

		}
	}

	public void setValue(int value, int row, int col) {
		insertSorted(value, row, col);
	}

	public ColumnLinkedList getValue(int index) {
		if (!isEmpty()) {
			for (RowNode cur = head; cur != null; cur = cur.getNext()) {
				if (cur.getrow() == index)
					return cur.getvalue();
			}
		}
		return null;
	}

	public void printMatrix() {
		int temp = 0;
		System.out.println("Print matrix: " + rows + " x " + cols);
		for (RowNode cur = head; temp < rows;) {
			if (cur == null || cur.getrow() != temp) {
				for (int j = 0; j < cols; ++j)
					System.out.print("0 ");
				System.out.println();
			} else {
				cur.getvalue().printArray();
				cur = cur.getNext();
			}
			temp++;
		}
		System.out.println();
	}

	public void printMatrixNonZero() {
		System.out.println("Print matrix none zeroes: " + rows + " x " + cols);
		for (RowNode cur = head; cur != null; cur = cur.getNext()) {
			cur.getvalue().printArrayNonZero();
			System.out.println();
		}
	}

	// o(n+m) time, where n nodes of first list and m nodes of second list
	private void merge_2SortedSparseArrays(SparseMatrix m1) {
		RowNode newHead = null, next = null, cur1 = head, cur2 = m1.getHead();
		while (cur2 != null && cur1 != null) {
			if (cur1.getrow() == cur2.getrow()) {
				cur1.getvalue().add(cur2.getvalue());
				link(next, cur1);
				next = cur1;
				cur1 = cur1.getNext();
				cur2 = cur2.getNext();
				length--;
			} else if (cur1.getrow() < cur2.getrow()) {
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
		}
		head = newHead;
		if (cur1 == null) {
			link(next, cur2);
			tail = m1.getTail();
		} else {
			link(next, cur1);
		}
	}

	public void add(SparseMatrix mat1) {
		merge_2SortedSparseArrays(mat1);
		length += mat1.getLength();
	}

}
