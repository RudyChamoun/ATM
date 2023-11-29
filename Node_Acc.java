package question2;
//Name :Roudy Chamoun  ID : 202001853
public class Node_Acc {
private Account acc;
private Node_Acc next;
private Node_Acc prev;

	public Node_Acc(Account a) {
		acc = a;
		next = null;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account a) {
		acc = a;
	}

	public Node_Acc getNext() {
		return next;
	}

	public void setNext(Node_Acc n_a) {
		next = n_a;
	}

	public Node_Acc getPrev() {
		return prev;
	}

	public void setPrev(Node_Acc n_a) {
		prev = n_a;
	}
	
}
