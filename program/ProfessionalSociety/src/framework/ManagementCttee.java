//(20�֣�

package framework;

import java.util.*;

/**
 * This class models a society management committee. //��1�֣�
 * 
 * @author A Jiayi
 * @version 1.0.0
 *
 */
public class ManagementCttee { // ��1�֣�
	/**
	 * Committee's members. // (2��)
	 */
	private Vector<SeniorMember> seniorMembers;

	/**
	 * Constructs a <code>ManagementCttee</code> object. // (3��)
	 */
	public ManagementCttee() {
		seniorMembers = new Vector<SeniorMember>();
	}

	/**
	 * Add a senior member to committee. // (3��)
	 */
	public void addCtteeMember(SeniorMember s) {
		seniorMembers.add(s);
	}

	/**
	 * Remove a senior member from committee. // (1��)
	 */
	public void removeCtteeMember(String name) { // (1��)
		for (Iterator<SeniorMember> i = getSeniorMembersIterator(); i.hasNext();) { // (2��)
			SeniorMember s = (SeniorMember) i.next(); // (2��)
			if (s.getName().equals(name)) { // (2��)
				seniorMembers.remove(s);
			}
		}
	}

	/**
	 * Returns an iterator over the senior members for the committee. // (1��)
	 *
	 * return an {@link Iterator}
	 */
	public Iterator<SeniorMember> getSeniorMembersIterator() { // (1��)
		return seniorMembers.iterator();
	}
}
