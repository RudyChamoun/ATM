package question2;
//Name :Roudy Chamoun  ID : 202001853
public class LL_Accounts {
	private Node_Acc header;
	
	public LL_Accounts() {
		header = null;
	}
	public void setHeader(Node_Acc n) {
		header = n;
	}
	public Node_Acc getHeader() {
		return header;
	}
	
	public void addAccount(Account a) {
		// adds to the end of linked lists of accounts
		Node_Acc n = new Node_Acc(a);
		if(header==null)
			header = n;
		else {
			Node_Acc temp = header;
			while(temp.getNext()!=null) {
				temp = temp.getNext();		
			}
			temp.setNext(n);
	}
}
	public Node_Acc getAccount() {
		// returns the last account in the linked lists of accounts
		if(header==null)
			return null;
		else {
			Node_Acc temp = header;
			while(temp.getNext()!=null) {
				temp = temp.getNext();
				}
			temp.getPrev().setNext(null);
			return temp;
		}
	}
	
	public Node_Acc find(int num) {
		//method is given the acc nbr and it returns the Node containing this account
		String num_str = num+"";
		Node_Acc temp = header;
		while(temp!=null) {
			if((temp.getAcc().getAcc_nbr()).equalsIgnoreCase(num_str))
				return temp;
			else
				temp = temp.getNext();
		}
		return null;
	}
	public String displayAccounts() {
		//method returns a string representation of the account (acc nbr and balance)
		String answer = "";
		Node_Acc temp = header;
		while(temp!=null) {
			answer+= temp.getAcc().printAcc()+"\n";
			temp = temp.getNext();
		}
		return answer;
	}
}
