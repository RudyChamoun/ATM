package question2;
//Name :Roudy Chamoun  ID : 202001853
public class Person {
	protected String name;
	protected String client_nbr;
	protected LL_Accounts accounts;
	
	public Person(String n,String c_n,LL_Accounts l) {
		name = n;
		client_nbr = c_n;
		accounts = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getClient_nbr() {
		return client_nbr;
	}

	public void setClient_nbr(String c_n) {
		client_nbr = c_n;
	}

	public LL_Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(LL_Accounts acc) {
		accounts = acc;
	}
	//overriden toString method of a person
	public String toString() {
		return "Name : "+name+" \nClient Number : "+client_nbr+ " \nAccounts\n------------ " + accounts.displayAccounts();
	}
	
}
