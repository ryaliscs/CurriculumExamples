package in.arrays;

public class MatrixRotation {

	public static void main(String[] args) {
		int f = 3;
		int s = 3;
		// int m[][] = { { 2, 3 }, { 4, 5 } };
		int m[][] = { { 2, 3, 6 }, { 4, 5, 7 }, { 8, 9, 10 } };
		// int m[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13,
		// 14, 15, 16, 17, 18 }, //
		// { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17,
		// 18 } };

		int[][] rm = new int[s][f];
		System.out.println("Orginal Matrix:");

		printMatrix(f, s, m);

		System.out.println("sum of corners :" + sumOfCorners(f, m));

		for (int i = s - 1, k = 0; i >= 0; i--, k++) {
			for (int j = 0; j < s; j++) {
				rm[j][k] = m[i][j];
			}
		}
		System.out.println("Rotated:");
		printMatrix(f, s, rm);
		System.out.println("sum of corners :" + sumOfCorners(f, rm));
	}

	private static int sumOfCorners(int f, int[][] matrix) {
		int min = 0, max = f - 1;
		return matrix[min][min] + matrix[min][max] + matrix[max][min] + matrix[max][max];
	}

	private static void printMatrix(int f, int s, int[][] m) {
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < s; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
