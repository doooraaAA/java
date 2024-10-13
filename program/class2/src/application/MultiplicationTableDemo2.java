package application;
import base.MultiplicationTable;

/**
 * The application class for the multiplication table
 * 
 * @author AJiayi
 * @see base.MultiplicationTable
 * 
 */
public class MultiplicationTableDemo2 {
	public static void main(String[] args) {
		/**
		 * Declare and create an object of MultiplicationTable
		 */
		MultiplicationTable nineTable = new MultiplicationTable();

		/**
		 * Output the specified row for the multiplication table
		 */
		System.out.println("Output the specified row by using <MultiplicationTable>");
		nineTable.nineTableSpecifiedRow(5);

		/**
		 * Output the specified column for the multiplication table
		 */
		System.out.println("Output the specified column by using <MultiplicationTable>");
		nineTable.nineTableSpecifiedColumn(3);

		/**
		 * Output the whole multiplication table
		 */
		System.out.println("Output the whole table by using <MultiplicationTable>");
		nineTable.nineTableAll();

		/**
		 * Output the whole multiplication table by using <NineTableDemo1>
		 */
		System.out.println();
		System.out.println("Output the whole table by using <MultiplicationTableDemo1>");
		MultiplicationTableDemo1.main(args);
	}
}
