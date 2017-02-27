package coinpurse;

/**
 * Abstract class implements Valuable interface use to extended by valuable
 * things in the purse. Consist of Value, Currency, equals, and compareTo.
 * 
 * @author Pawan Intawongsa
 */
public abstract class AbstractValuable implements Valuable {
	double value;
	String currency;
	static String DEFAULT_CURRENCY = "baht";

	/**
	 * initialized value of valueble.
	 * 
	 * @param value
	 *            is value of the valuable
	 */
	public AbstractValuable(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * initialized valuable with the currency.
	 * 
	 * @param value
	 *            is value of valueble
	 * @param currency
	 *            is currency of currency
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Check if 2 object are equal.
	 * 
	 * @param arg
	 *            is the object to equal with this valuable.
	 * @return true if the valuables are equal, false if they aren't equal.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (this.value == other.getValue() && this.currency.equalsIgnoreCase(other.getCurrency())) {
			return true;
		}
		return false;
	}

	/**
	 * Compare this valuable with another valuable. Return -1 or 0 or 1 for each
	 * case.
	 * 
	 * @param v
	 *            is the another valuable to compare with.
	 * @return -1 if another valuable is null or this valuable is less than
	 *         another valuable, 0 if they are equal, 1 if this valuable is more
	 *         than another valuable.
	 */

	public int compareTo(Valuable val) {
		if (val == null)
			return -1;
		return (int) Math.signum(this.value - val.getValue());

	}

	/**
	 * Get value of value
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get currency of currency
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

}
