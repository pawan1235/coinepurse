package coinpurse;

public class Coin implements Comparable<Coin> {
	private double value;
	private String currency = "Baht";

	public Coin(double value) {
		this.value = value;
	}

	public Coin(double value, String curr) {
		this.value = value;
		this.currency = curr;
	}

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

	public int compareTo(Coin c) {
		if (c == null)
			return -1;
		return (int) Math.signum(this.value - c.value);

	}

	public double getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	public String toString() {
		return String.format("%.2f-%s", this.value, this.currency);
	}
}
