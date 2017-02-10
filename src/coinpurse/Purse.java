package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	// TODO declare a List of Coins named "money".
	List<Coin> money = new ArrayList<Coin>();

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
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
		for (Coin coin : money) {
			total += coin.getValue();
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
	public boolean insert(Coin coin) {
		if (!isFull() && coin.getValue() != 0) {
			money.add(coin);
			Collections.sort(money);
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
	public Coin[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}

		List<Coin> templist = new ArrayList<Coin>();
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
		Coin[] array = new Coin[templist.size()];
		templist.toArray(array);
		return array;

	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * 
	 * @return money in the purse
	 */
	public String toString() {
		// TODO complete this
		return "you forgot to write Purse.toString()";
	}

}
// TODO remove the TODO comments after you complete them.
// TODO When you are finished, there should not be any TODO. Including this one.
