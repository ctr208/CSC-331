package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a Matrix class.
 * 
 * @author Robison
 * 
 *
 */

public class Matrix {
	private double[][] array;
	private int numRows;
	private int numCols;

	/*
	 * This is a constructor for a Matrix object that takes a 2d array as a
	 * parameter.
	 * 
	 */

	public Matrix(double[][] data) {
		array = data;
		numRows = array.length;
		numCols = array[0].length;

	}

	/*
	 * This is a constructor for a Matrix object that takes a file as a parameter.
	 * 
	 */

	public Matrix(String file) {
		getDemensions(file);
		createMatrix(file);
	}

	/**
	 * Gets number of columns.
	 * 
	 * @return number of columns
	 */

	public int getNumCol() {
		return numCols;
	}

	/**
	 * Gets number of rows.
	 * 
	 * @return number of rows
	 *
	 */

	public int getNumRow() {
		return numRows;
	}

	/**
	 * Gets 2d array.
	 * 
	 * @return 2d array
	 */

	public double[][] getArray() {
		return array;
	}

	/**
	 * Determines amount of rows and columns for matrix by reading file. Then sets
	 * the variables numRows and NumCols accordingly.
	 * 
	 * @param fileName file to be read
	 */

	public void getDemensions(String fileName) {
		Scanner input = null;
		int numRow = 0;
		int numCol = 0;
		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		while (input.hasNextLine() == true) {
			input.nextLine();
			numCol++;
		}
		numCol++;
		this.numCols = numCol;
		input.close();

		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		while (input.hasNextLine() == true) {
			numRow++;
			input.nextLine();

		}
		this.numRows = numRow;
		input.close();
	}

	/**
	 * Fills the array with the contents of the file.
	 * 
	 * @param fileName file to be read
	 */

	public void createMatrix(String fileName) {
		this.array = new double[numRows][numCols];
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		while (input.hasNextDouble()) {
			for (int row = 0; row < array.length; row++) {
				for (int col = 0; col < array[row].length; col++) {
					double x = input.nextDouble();
					array[row][col] = x;
				}
			}

		}

	}

	/**
	 * Produces transpose of this matrix.
	 * 
	 * @return transpose of Matrix
	 */

	public Matrix transpose() {

		double[][] temp = new double[this.numCols][this.numRows];
		for (int row = 0; row < this.numRows; row++) {
			for (int col = 0; col < this.numCols; col++) {
				temp[col][row] = array[row][col];
			}
		}
		Matrix temp1 = new Matrix(temp);
		return temp1;
	}

	/**
	 * Takes this matrix and adds it to another matrix. Returns a new matrix.
	 * 
	 * @param matrix matrix to add by
	 * @return sum of two matrices
	 */

	public Matrix add(Matrix matrix) {

		double[][] temp = new double[numRows][numCols];
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				temp[row][col] = array[row][col] + matrix.getArray()[row][col];
			}
		}
		Matrix temp1 = new Matrix(temp);
		return temp1;
	}

	/**
	 * Multiplies this matrix by a scalar. Returns new matrix.
	 * 
	 * @param multiplier scalar to perform scalar multiplication
	 * @return product of matrix and scalar
	 */

	public Matrix mult(double multiplier) {
		double[][] temp = new double[numRows][numCols];
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				temp[row][col] = array[row][col] * 2;
			}
		}
		Matrix temp1 = new Matrix(temp);
		return temp1;
	}

	/**
	 * Multiplies this matrix by another matrix. Returns a new matrix.
	 * 
	 * @param matrix matrix to multiply by
	 * @return product of two matrices
	 */

	public Matrix mult(Matrix matrix) {
		double[][] temp = new double[numRows][matrix.getNumCol()];
		for (int row1 = 0; row1 < numRows; row1++) {
			for (int col2 = 0; col2 < matrix.getNumCol(); col2++) {
				for (int col1 = 0; col1 < numCols; col1++) {
					temp[row1][col2] += array[row1][col1] * matrix.getArray()[col1][col2];
				}

			}
		}
		Matrix temp1 = new Matrix(temp);
		return temp1;
	}

	/**
	 * Converts matrix object into a string showing all of its contents by row and
	 * column.
	 * 
	 * @return contents of array by row and column
	 */

	public String toString() {
		System.out.println(numRows + "x" + numCols + " Matrix");
		String arrayString = "";

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				String y = String.valueOf(array[row][col] + " ");
				arrayString = arrayString.concat(y);
			}
			arrayString.trim();
			arrayString = arrayString.concat("\n");
		}

		return arrayString;
	}

	/**
	 * Compares two matrices to see if they have the same contents.
	 * 
	 * @param object Matrix to compare
	 * @return true or false
	 */

	public boolean equals(Matrix object) {
		boolean switch1 = true;
		if (numRows != object.getNumRow() || numCols != object.getNumCol()) {
			return false;
		}

		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (array[row][col] != object.getArray()[row][col]) {
					switch1 = false;
				}
			}
		}
		return switch1;
	}

}
