package projects.sparse_matrix;

public class SparseArray_and_MatrixApp {
	public static void main(String[] args) {
		SparseMatrix matrix = new SparseMatrix(10, 10);
		matrix.setValue(5, 3, 5);
		matrix.setValue(7, 3, 6);
		matrix.setValue(2, 3, 2);
		matrix.setValue(0, 3, 2);
		matrix.setValue(6, 5, 6);
		matrix.setValue(4, 5, 4);
		matrix.setValue(3, 7, 3);
		matrix.setValue(1, 7, 1);

		matrix.printMatrix();
		matrix.printMatrixNonZero();

		SparseMatrix matrix2 = new SparseMatrix(10, 10);
		matrix2.setValue(5, 1, 9);
		matrix2.setValue(6, 3, 8);
		matrix2.setValue(9, 9, 9);

		matrix2.printMatrix();
		matrix2.printMatrixNonZero();

		System.out.println("**********************************");
		matrix.add(matrix2);
		matrix.printMatrix();
		matrix.printMatrixNonZero();

	}
}
