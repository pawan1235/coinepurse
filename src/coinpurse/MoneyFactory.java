package coinpurse;

/**
 * An abstract class for each country money factory to edit for their currency.
 * It contains some method that every factory must have.
 * 
 * @author Chawakorn Suphepre
 */
public abstract class MoneyFactory {
	private static MoneyFactory instacne;

	/**
	 * Protected MoneyFactory's constuctor so other class can't call new
	 * MonetFactory.
	 */
	protected MoneyFactory() {
	}

	/**
	 * retuen instacne of MoneyFactory.
	 * 
	 * @return instacne of MoneyFactory
	 */
	static MoneyFactory getInstance() {
		if (instacne == null) {
			System.exit(1);
		}
		return instacne;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public abstract Valuable createMoney(double value);

	{

	}

	/**
	 * parse a String value to double and return it in double.
	 * 
	 * @param value
	 *            amout of money to be set
	 * @return value in double
	 */
	public Valuable createMoney(String value) {
		double val = Double.parseDouble(value);
		return createMoney(val);

	}

	/**
	 * Set the factory to f in the parameter.
	 * 
	 * @param moneyfactory
	 *            is the MoneyFactory to set.
	 */
	static void setMoneyFactory(MoneyFactory moneyfactory) {
		instacne = moneyfactory;
	}
}
