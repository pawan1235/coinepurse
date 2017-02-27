package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Pawan Intawongsa
 */
public class Main {

	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory instance = null;
		try{
			instance = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce){
			System.out.println(factoryclass+" is not type Moneyfactory");
		}
		catch(Exception ex){
			System.out.println("Error creating MoneyFactory "+ex.getMessage());
		}
		if(instance == null) System.exit(1);
		MoneyFactory.setMoneyFactory(instance);
		// 1. create a Purse
		Purse purse = new Purse(CAPACITY);
		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog ui = new ConsoleDialog(purse);
		// 3. run the ConsoleDialog
		ui.run();

	}
}
