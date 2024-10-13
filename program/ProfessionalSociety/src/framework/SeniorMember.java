//（10分）

package framework;

/**
 * This class models a society senior member. //（1分）
 * 
 * @author A Jiayi
 * @version 1.0.0
 *
 */
public class SeniorMember extends Member { // （1分）
	/**
	 * Senior member's information: fee. // (1分)
	 */
	private int fee;

	/**
	 * Constructs a <code>SeniorMember</code> object. // (4分)
	 * 
	 * @param initialName    the name of this senior member
	 * @param initialAddress the address of this senior member
	 * @param initialFee     the fee of this senior member
	 */
	public SeniorMember(String initialName, String initialAddress, int initialFee) {
		super(initialName, initialAddress);
		fee = initialFee;

	}

	/**
	 * Returns the fee of this member. // (3分)
	 *
	 * @return the fee of this member.
	 */
	public int getFee() {
		return fee;
	}

}
