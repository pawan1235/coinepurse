package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * 
 * @author Pawan Intawongsa
 */
public interface Valuable {
	/**
	 * Get the value of this object.
	 * 
	 * @return object's value
	 */
	public double getValue();

	/**
	 * Get object's currency.
	 * 
	 * @return currency of object
	 */
	public String getCurrency();
}
