package base;

/**
 * The basic class for the multiplication table
 * 
 * @author AJiayi
 * 
 */
public class MultiplicationTable {
	/**
	 * Output the specified <code>row<code> of the multiplication table
	 * @param row
	 */
	public void nineTableSpecifiedRow(int row) {
		for (int i = 1; i <= row; i++) {
			System.out.print(i + "*" + row + "=" + (row * i) + "\t");
		}
		System.out.println("\n");
	}

	/**
	 * Output the specified <code>column<code> of the multiplication table
	 * @param column
	 */
	public void nineTableSpecifiedColumn(int column) {
		for (int i = column; i <= 9; i++) {
			System.out.println(column + "*" + i + "=" + (column * i));
		}
		System.out.println();
	}

	/**
	 * Output the whole multiplication table
	 */
	public void nineTableAll() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}
}
