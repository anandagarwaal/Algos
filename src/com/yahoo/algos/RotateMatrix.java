package com.yahoo.algos;

public class RotateMatrix {
	/**
	 * Rotate Matrix by 90 degree
	 */

	static int[][] matrixA = 
		{{1,2,3,4},
		 {5,6,7,8},
    	 {9,10,11,12}};
	
	static int row=3, col=4;
	static int[][] matrixB = new int[col][row];
	
	private static void rotateMatrix(){
		for (int i=0;i<=row-1;i++){
			for (int j=0;j<=col-1;j++){
				matrixB[j][row-1-i] = matrixA[i][j];  // NOTE just this :)
			}
		}
	}
	
	private static void printMatrix(int[][] mat, int row, int col){
		for (int i=0;i<=row-1;i++){
			for (int j=0;j<=col-1;j++){
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		printMatrix(matrixA, row, col);
		rotateMatrix();
		System.out.println("---------");
		printMatrix(matrixB, col, row);
	}

}
