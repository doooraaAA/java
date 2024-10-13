//��8�֣�

package framework;

/**
 * This class models a society standard member. //��1�֣�
 * 
 * @author A Jiayi
 * @version 1.0.0
 *
 */
public class StandardMember extends Member { // (1��)
	/**
	 * Constructs a <code>StandardMember</code> object. // (3��)
	 * 
	 * @param initialName    the name of this senior member
	 * @param initialAddress the address of this senior member
	 */
	public StandardMember(String initialName, String initialAddress) {
		super(initialName, initialAddress);
	}

	/**
	 * Returns the fee of this member. // (3��)
	 * Standard member fee's default value is 500.
	 * 
	 * @return the fee of this member.
	 */
	public int getFee() {
		return 500;
	}

}
