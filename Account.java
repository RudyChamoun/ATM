package question2;
//Name :Roudy Chamoun  ID : 202001853
public class Account {
	protected String acc_nbr;
	protected String type;
	protected String balance;
	
	public Account(String a_n,String ty,String bl) {
		acc_nbr = a_n;
		type = ty;
		balance = bl;
	}

	public String getAcc_nbr() {
		return acc_nbr;
	}

	public void setAcc_nbr(String a_n) {
		acc_nbr = a_n;
	}

	public String getType() {
		return type;
	}

	public void setType(String ty) {
		type = ty;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String bl) {
		balance = bl;
	}
	
	public String toString() {
		return "Account Number : "+acc_nbr+"\nBalance : "+balance;
	}
	public String printAcc() {
		return "\nAccount Number : "+acc_nbr+" Balance : "+balance;
	}
	
}
