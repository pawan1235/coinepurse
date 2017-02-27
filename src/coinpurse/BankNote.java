package coinpurse;

/**
 * A banknote with a monetary value and currency.
 * 
 * @author Pawan Intawongsa
 *
 */
public class BankNote extends AbstractValuable {
	/** Unique serial number of banknote */
	private long serialNumber;
	private static long nextSerialNumber = 1000000;

	/**
	 * Initialize bank note with given value.
	 * 
	 * @param value
	 *            is value of bank note
	 */
	public BankNote(double value) {
		super(value);
		serialNumber = nextSerialNumber++;
	}

	/**
	 * Initialize bank note with given value and currency.
	 * 
	 * @param value
	 *            is value of banknote
	 * @param currency
	 *            is currency of banknote
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		serialNumber = nextSerialNumber++;
	}

	/**
	 * Check if two bank noteare equal.
	 * 
	 * @return true if it equal false if it is not
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (this.value == other.value && this.currency.equalsIgnoreCase(other.currency)) {
			return true;
		}
		return false;
	}

	/**
	 * Return value and currency of bank note.
	 * 
	 * @return banknote's value and currency
	 */
	public String toString() {
		return super.value + "-" + super.currency + " note[" + this.getSerialNumber() + "]";
	}

	/**
	 * Get serial number of banknote.
	 * 
	 * @return banknote's serial number
	 */
	public long getSerialNumber() {
		return serialNumber;
	}


}
