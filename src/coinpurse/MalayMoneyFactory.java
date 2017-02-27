package coinpurse;

/**
 * A MoneyFactory for Malay money. Used to create the Ringgit coin, Sen coin,
 * and Ringgint bank note.
 * 
 * @author Pawan Intawongsa
 */
public class MalayMoneyFactory extends MoneyFactory {
	/**
	 * Create Coin and Banknote if the input value is in the list. else throw
	 * IllegalArgumentException.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (!checkVal(value)) {
			throw new IllegalArgumentException();
		}
		if (value < 1) {
			Coin c = new Coin(value, "Ringgit");
			return c;
		} else {
			BankNote b = new BankNote(value, "Ringgit");
			return b;
		}
	}

	/**
	 * Check if input value is in the list.
	 * 
	 * @param value
	 *            input value
	 * @return true if it on the list else return false
	 */
	private boolean checkVal(double value) {
		double[] vals = { 0.05, 0.10, 0.20, 0.5, 1, 2, 5, 10, 20, 50, 100 };
		for (double val : vals) {
			if (value == val) {
				return true;
			}
		}
		return false;
	}

}
