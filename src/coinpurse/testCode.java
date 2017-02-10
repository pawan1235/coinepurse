package coinpurse;

import coinpurse.Coin;

public class testCode {
	public static void main(String[] args) {
		Coin one = new Coin(1);
		Coin five = new Coin(5);
		// Coin malay = new Coin(.25, "Ringgit");
		// System.out.println(one.toString());
		// System.out.println(malay.toString());
		// System.out.println(one.equals(one));
		// System.out.println(five.compareTo(one));
		Purse p1 = new Purse(3);
		p1.insert(new Coin(10));
		p1.insert(new Coin(2));
		p1.insert(new Coin(1));
		System.out.println(p1.getBalance());
		for (Coin c : p1.withdraw(13)) {
			System.out.println(c.getValue());
		}

	}
}
