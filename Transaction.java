package question2;
//Name :Roudy Chamoun  ID : 202001853
public class Transaction {
	protected Person person;
	protected String date;
	protected int time;
	protected String type;
	protected int amount;
	
	public Transaction(Person p,String dt,int tm,String ty,int amnt) {
		person = p;
		date = dt;
		time = tm;
		type = ty;
		amount = amnt;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person p) {
		person = p;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String dt) {
		date = dt;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int tm) {
		time = tm;
	}

	public String getType() {
		return type;
	}

	public void setType(String ty) {
		type = ty;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amnt) {
		amount = amnt;
	}
	//overriden toString method
	public String toString() {
		return "Type of Transaction : "+type+" , Day of Transaction : "+date +" , Time of Transaction : "+time+" , Amount of transaction : "+amount;
	}
	
}
