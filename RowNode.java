package projects.sparse_matrix;

public class RowNode {
	private ColumnLinkedList value;
	private int row;
	private RowNode next;
	private RowNode previous;

	public RowNode(int row, int cols) {
		value = new ColumnLinkedList(cols);
		this.row = row;
	}

	public int getrow() {
		return row;
	}

	public void setrow(int row) {
		this.row = row;
	}

	public void setPrevious(RowNode previous) {
		this.previous = previous;
	}

	public RowNode getPrevious() {
		return previous;
	}

	public void setNext(RowNode next) {
		this.next = next;
	}

	public RowNode getNext() {
		return next;
	}

	public ColumnLinkedList getvalue() {
		return value;
	}

	public void setvalue(int value, int col) {
		this.value.setValue(value, col);
	}
}
