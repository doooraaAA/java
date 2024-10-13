//(20分）

package framework;

import java.util.*;

/**
 * This class models a society management committee. //（1分）
 * 
 * @author A Jiayi
 * @version 1.0.0
 *
 */
public class ManagementCttee { // （1分）
	/**
	 * Committee's members. // (2分)
	 */
	private Vector<SeniorMember> seniorMembers;

	/**
	 * Constructs a <code>ManagementCttee</code> object. // (3分)
	 */
	public ManagementCttee() {
		seniorMembers = new Vector<SeniorMember>();
	}

	/**
	 * Add a senior member to committee. // (3分)
	 */
	public void addCtteeMember(SeniorMember s) {
		seniorMembers.add(s);
	}

	/**
	 * Remove a senior member from committee. // (1分)
	 */
	public void removeCtteeMember(String name) { // (1分)
		for (Iterator<SeniorMember> i = getSeniorMembersIterator(); i.hasNext();) { // (2分)
			SeniorMember s = (SeniorMember) i.next(); // (2分)
			if (s.getName().equals(name)) { // (2分)
				seniorMembers.remove(s);
			}
		}
	}

	/**
	 * Returns an iterator over the senior members for the committee. // (1分)
	 *
	 * return an {@link Iterator}
	 */
	public Iterator<SeniorMember> getSeniorMembersIterator() { // (1分)
		return seniorMembers.iterator();
	}
}
