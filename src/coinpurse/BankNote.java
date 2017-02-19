package coinpurse;

public class BankNote implements Valuable {
	private String currency;
	private long serialNumber;
	private double value;
	private static long nextSerialNumber = 1000000;

	public BankNote(double value) {
		this.value = value;
		this.currency = "Baht.";
		serialNumber = nextSerialNumber + 1;
	}

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		serialNumber = nextSerialNumber + 1;
	}

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

	public String toString() {
		return this.value + "-" + this.currency + " note[" + this.getSerialNumber() + "]";
	}

	public String getCurrency() {
		return currency;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public double getValue() {
		return value;
	}

}
