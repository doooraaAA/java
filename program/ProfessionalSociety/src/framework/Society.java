//（35分）

package framework;

import java.util.*;

/**
 * This class models a professional society. //（1分）
 * 
 * @author A Jiayi
 * @version 1.0.0
 *
 */
public class Society { // （1分）
	/**
	 * Society's information: name, members and management committee. // (4分)
	 */
	private String name;
	private Vector<Member> members;
	private ManagementCttee mCttee;

	/**
	 * Constructs a <code>Society</code> object. // (5分)
	 * 
	 * @param initialName the name of this professional society.
	 */
	public Society(String initialName) {
		name = initialName;
		members = new Vector<Member>();
		mCttee = new ManagementCttee();
	}

	/**
	 * Returns the name of this society. // (3分)
	 *
	 * @return the name of this society.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns all members of this society. // (3分)
	 *
	 * @return all members of this society.
	 */
	public Vector<Member> getMembers() {
		return members;
	}
	
	/**
	 * Returns the committee of this society. // (3分)
	 *
	 * @return the committee of this society.
	 */
	public ManagementCttee getManagementCttee() {
		return mCttee;
	}
	

	/**
	 * Add a standard member to society. // (4分)
	 */
	public void addMember(String name, String address) {
		Member newMember = new StandardMember(name, address);
		members.add(newMember);
	}

	/**
	 * Add a senior member to society. // (4分)
	 */
	public void addSeniorMember(String name, String address, int fee) {
		Member newMember = new SeniorMember(name, address, fee);
		members.add(newMember);
	}

	/**
	 * Add a senior member to committee. // (3分)
	 */
	public void addCtteeMember(SeniorMember member) {
		mCttee.addCtteeMember(member);
	}
	
	/**
	 * Returns the total fee of this society. // (4分)
	 * 
	 * @return the total fee of this society.
	 */
	public int getFeeTotal() {
		int total = 0;
		for (Member i : members) {
			total += i.getFee();
		}
		return total;
	}
}
