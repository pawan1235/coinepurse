package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Pawan Intawongsa
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0;
		for (Valuable val : money) {
			total += val.getValue();
		}
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */

	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() != this.capacity) {
			return false;
		}
		return true;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable coin) {
		if (!isFull() && coin.getValue() != 0) {
			money.add(coin);
			money.sort(new CompareValue());
			Collections.reverse(money);
			return true;
		}

		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}

		List<Valuable> templist = new ArrayList<Valuable>();
		for (int i = 0; i < money.size(); i++) {
			if (money.get(i).getValue() <= amount) {
				templist.add(money.get(i));
				amount -= money.get(i).getValue();
				money.remove(i);
				i--;
			}
		}
		if (amount > 0) {
			money.addAll(templist);
			return null;
		}
		Valuable[] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array;

	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * 
	 * @return money in the purse
	 */
	public String toString() {
		int countCoins = 0;
		int countBank = 0;
		double bankBalace = 0;
		double coinBalace = 0;
		for (Valuable v : this.money) {
			if (v.getValue() < 20) {
				countCoins++;
				coinBalace += v.getValue();
			} else {
				countBank++;
				bankBalace += v.getValue();
			}
		}
		return countCoins + " coins with value " + coinBalace + "\n" + countBank + " notes with value " + bankBalace;
	}

}

/**
 * Interface comparator of Valueble
 * 
 * @author Pawan Intawongsa
 *
 */
class CompareValue implements Comparator<Valuable> {

	@Override
	public int compare(Valuable o1, Valuable o2) {
		return (int) Math.signum(o1.getValue() - o2.getValue());
	}

}