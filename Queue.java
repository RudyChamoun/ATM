package question2;
//Name :Roudy Chamoun  ID : 202001853
public class Queue {
	private int front;
	private int rear;
	private int capacity;
	private Transaction[] atm;
	
	public Queue(int cap) {
		capacity = cap;
		atm = new Transaction[cap];
		front = -1;
		rear = -1;
	}
	 public boolean isEmpty() {
	        return front == -1;
	    }
	 
	   
	    public boolean isFull() {
	        return rear == capacity - 1;
	    }
	 
	    
	    public void enqueue(Transaction tr) {
	        if (isFull()) {
	            ensureCapacity();
	        }
	        if (isEmpty()) {
	            front = 0;
	            rear = 0;
	        } else {
	            rear++;
	        }
	        atm[rear] = tr;
	    }
	    
	    public Transaction dequeue() {
	        Transaction tr;
	        if (isEmpty()) {
	            System.out.println("ATM is empty!");
	            return null;
	        } else if (front == rear) {
	            tr = atm[front];
	            front = -1;
	            rear = -1;
	        } else {
	            tr = atm[front];
	            front++;
	        }
	        return tr;
	    }
	    
	    public void printQueue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty!");
	            return;
	        }
	        System.out.print("Transactions after 6 pm that are yet to be processed : ");
	        for (int i = front; i <= rear; i++) {
	            System.out.print(atm[i] + "\n ");
	        }
	        System.out.println();
	    }
	 
	    // Ensure that there is enough capacity in the array
	    private void ensureCapacity() {
	        int newSize = capacity * 2;
	        Transaction[] newArray = new Transaction[newSize];
	        for (int i = front; i <= rear; i++) {
	            newArray[i - front] = atm[i];
	        }
	        capacity = newSize;
	        atm = newArray;
	        rear = rear - front;
	        front = 0;
	    }
	    
}
