//（10分）

package application;

import java.io.*;
import java.util.Iterator;

import framework.*;

/**
 * This class implements a society member management.
 *
 * @author A Jiayi
 * @version 1.1.0
 * @see Society
 * @see ManagementCttee
 * @see Member
 * @see StandardMember
 * @see SeniorMember
 */
public class SocietyAppDemo { // （1分）

	/**
	 * Standard input/output stream objects for console i/o, and society's info. //（1分）
	 */
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private Society society;

	/**
	 * Starts the application. //（1分）
	 *
	 * @param args String arguments. Not used.
	 * @throws IOException if there are errors in the input.
	 */
	public static void main(String[] args) throws IOException {
		SocietyAppDemo application = new SocietyAppDemo();
		application.run();

	}

	/**
	 * Constructs a <code>SocietyAppDemo</code> object //（1分）
	 * and initializes the name of this society.
	 *
	 */
	private SocietyAppDemo() {
		society = new Society("Sichuan Cyber Security Association");
	}

	/**
	 * Displays a menu of options and verifies the user's choice. //（1分）
	 *
	 * @return an integer in the range [0,4]
	 */
	private int getChoice() throws IOException {

		int input;

		do {
			try {
				stdOut.println();
				stdOut.print(
						"Welcome to " + society.getName() + ": \n" + "[0] Quit\n" + "[1] Register a standard member\n"
								+ "[2] Register a senior member\n" + "[3] Add a senior member to the committee\n"
								+ "[4] Check the total fee of the society\n" + "choice> ");
				stdOut.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdOut.println();

				if (0 <= input && 4 >= input) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}
	
	/**
	 * Presents the user with a menu of options and executes the selected task. //（1分）
	 */
	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {

			if (choice == 1) {
				registerStandardMember();
			} else if (choice == 2) {
				registerSeniorMember();
			} else if (choice == 3) {
				addSeniorMemberToCttee();
			} else if (choice == 4) {
				stdOut.println("The society total fee: " + getTotalFee());
			}
			choice = getChoice();
		}
	}

	/**
	 * Register a standard member to the society. //（1分）
	 */
	private void registerStandardMember() throws IOException {
		stdOut.println("The member's name> ");
		String name = stdIn.readLine();
		for (Member m : society.getMembers()) {
			if (m.getName().equals(name)) {
				stdErr.println("The member with name '" + name + "' is already exist!> ");
				return;
			}
		}
		stdOut.println("The member's address> ");
		String address = stdIn.readLine();
		society.addMember(name, address);
		stdErr.println("Register a standard member successful!");
	}

	/**
	 * Register a senior member to the society. //（1分）
	 */
	private void registerSeniorMember() throws IOException {
		stdOut.println("The senior member's name> ");
		String name = stdIn.readLine();
		for (Member m : society.getMembers()) {
			if (m.getName().equals(name)) {
				stdErr.println("The member with name '" + name + "' is already exist!> ");
				return;
			}
		}
		stdOut.println("The senior member's address> ");
		String address = stdIn.readLine();
		int fee = 0;
		do {
			stdOut.println("The senior member's fee> ");
			try {
				fee = Integer.parseInt(stdIn.readLine());
				break;
			} catch(NumberFormatException ne) {
				stdErr.println("The senior member's fee is not a number!> ");
			}
		} while (true);
		society.addSeniorMember(name, address, fee);
		stdErr.println("Register a senior member successful!");
	}

	/**
	 * Add a senior member to the committee. //（1分）
	 */
	private void addSeniorMemberToCttee() throws IOException {
		stdOut.println("The senior member's name> ");
		String name = stdIn.readLine();
		for (Iterator<Member> i = (society.getMembers()).iterator(); i.hasNext();) {
			Member m = (Member) i.next();
			if (m instanceof SeniorMember && m.getName().equals(name)) {
				for (Iterator<SeniorMember> j = (society.getManagementCttee()).getSeniorMembersIterator(); j.hasNext();) {
					SeniorMember s = (SeniorMember) j.next();
					if (s.getName().equals(name)) {
						stdErr.println(name + " is already a member of the committee!");
						return;
					} 
				}
				(society.getManagementCttee()).addCtteeMember((SeniorMember)m);
				stdErr.println("Add a senior member to the committee successful!");
				return;
			}
		}
		stdErr.println(name + " is not a senior member or no such member!");
	}

	/**
	 * Check and display the total fee of the society. //（1分）
	 */
	private int getTotalFee() {
		return society.getFeeTotal();
	}
}
