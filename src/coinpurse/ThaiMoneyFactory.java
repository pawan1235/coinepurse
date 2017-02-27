package coinpurse;

/**
 * A MoneyFactory for Thai money. Used to create the Baht coin, Satang coin, and
 * Baht bank note.
 * 
 * @author Pawan Intawongsa
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/**
	 * Create Coin and Banknote if the input value is in the list. else throw
	 * IllegalArgumentException.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			BankNote b = new BankNote(value);
			return b;
		} else if (value == 0.25 || value == 0.5 || value == 1 || value == 2 || value == 5 || value == 10) {
			Coin c = new Coin(value);
			return c;
		}
		throw new IllegalArgumentException();

	}

}