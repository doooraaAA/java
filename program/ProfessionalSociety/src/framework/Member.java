//��17�֣�

package framework;

/**
 * This abstract class models a society member. //��1�֣�
 * 
 * @author A Jiayi
 * @version 1.0.0
 *
 */
public abstract class Member { //��1�֣�
	/**
	 * Member's information: name and address. // (3��)
	 */
	private String name;
	private String address;
	
	/**
	 * Constructs a <code>Member</code> object. // (4��)
	 * 
	 * @param initialName      the name of this member
	 * @param initialAddress   the address of this member
	 */
	public Member (String initialName, String initialAddress) {
         name = initialName;
         address = initialAddress;
	}
	
	/**
	 * Returns the name of this member. // (3��)
	 *
	 * @return the name of this member.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the address of this member. // (3��)
	 *
	 * @return the address of this member.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Abstract method. // (2��)
	 * Returns the fee of this member.
	 *
	 * @return the fee of this member.
	 */
	public abstract int getFee();
}
