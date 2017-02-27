package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author User
 *
 */
public class Coin extends AbstractValuable {
	/** The currency, of course. */
	static String DEFUALT_CURRENCY = "Baht";

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of coin
	 */
	public Coin(double value) {
		super(value, DEFUALT_CURRENCY);
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
		super(value, curr);
	}

	// /**
	// * Check if two coins are equal .
	// *
	// * @return if equal return yes else return no.
	// */
	// public boolean equals(Object arg) {
	// if (arg == null)
	// return false;
	// if (arg.getClass() != this.getClass())
	// return false;
	// Coin other = (Coin) arg;
	// if (this.value == other.value &&
	// this.currency.equalsIgnoreCase(other.currency)) {
	// return true;
	// }
	// return false;
	// }

	// /**
	// * Order coin by value
	// *
	// * @return return 0 if value equal if less return -1 if more than return 1
	// */
	// public int compareTo(Coin c) {
	// if (c == null)
	// return -1;
	// return (int) Math.signum(this.value - c.value);
	//
	// }

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
		if (super.currency.equals("Ringgit")) {
			return String.format("%.2f-Sen", this.value * 100);
		}
		if (super.DEFAULT_CURRENCY.equals(super.DEFAULT_CURRENCY)) {
			if (super.value < 1) {
				return String.format("%.2f-satang", this.value * 100);
			}
		}
		return String.format("%.2f-%s ", this.value, this.currency);
	}
}
