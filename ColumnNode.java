package projects.sparse_matrix;

/**
 * 
 * @AhmedHadaka
 */
public class ColumnNode {

	private int value;
	private int column;
	private ColumnNode next;
	private ColumnNode previous;

	public ColumnNode(int value, int column) {
		this.value = value;
		this.column = column;
	}

	public int getcolumn() {
		return column;
	}

	public void setcolumn(int column) {
		this.column = column;
	}

	public void setPrevious(ColumnNode previous) {
		this.previous = previous;
	}

	public ColumnNode getPrevious() {
		return previous;
	}

	public void setNext(ColumnNode next) {
		this.next = next;
	}

	public ColumnNode getNext() {
		return next;
	}

	public int getvalue() {
		return value;
	}

	public void setvalue(int value) {
		this.value = value;
	}

}
