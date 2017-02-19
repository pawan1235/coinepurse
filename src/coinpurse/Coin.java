package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author User
 *
 */
public class Coin implements Comparable<Coin>,Valuable {
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency = "Baht";

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of coin
	 */
	public Coin(double value) {
		this.value = value;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            of coin
	 * @param currency
	 *            of coin
	 */
	public Coin(double value, String curr) {
		this.value = value;
		this.currency = curr;
	}

	/**
	 * Check if two coins are equal .
	 * 
	 * @return if equal return yes else return no.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (this.value == other.value && this.currency.equalsIgnoreCase(other.currency)) {
			return true;
		}
		return false;
	}

	/**
	 * Order coin by value
	 * 
	 * @return return 0 if value equal if less return -1 if more than return 1
	 */
	public int compareTo(Coin c) {
		if (c == null)
			return -1;
		return (int) Math.signum(this.value - c.value);

	}

	/**
	 * get Value of coin
	 * 
	 * @return value of coin
	 */
	public double getValue() {
		return value;
	}

	/**
	 * get Currency of coin
	 * 
	 * @return currency of coin
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * return coin information
	 * 
	 * @return coin's information
	 */
	public String toString() {
		return String.format("%.2f-%s ", this.value, this.currency);
	}
}
