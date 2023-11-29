package question2;
import java.io.*;
import java.time.*;
import java.util.*;
//Name :Roudy Chamoun  ID : 202001853
public class ATM {
	//to store persons we create at begining when program starts
	private static Vector<Person> list_pers;
	//to store transactions
	private static Queue transactions;
	
	
	public ATM(int cap) {
		list_pers = new Vector();
		transactions = new Queue(10);
	}
	
	    
	    public static boolean validateInput(String id,String pass) {
	    	//validates input if id and and pass in bank records (text files)
	    	try {
	    	Scanner fileScan = new Scanner(new File("C:\\Users\\user\\Desktop\\Spring23\\Objects & Data Abstraction\\Assignment4\\Information.txt"));
	    	String line = fileScan.nextLine();
	    	while(fileScan.hasNextLine()) {
	    		String[] arr = line.split(" ");
	    		if(arr[0].equals(id)&&arr[1].equals(pass))
	    			return true;
	    		else
	    			line = fileScan.nextLine();
	    	}
	    	}catch(FileNotFoundException e) {
	    		System.out.println("File was not Found ! Error in bank servers");
	    	}
	    	return false;
	    	
	    }
	    
	    public static void readInput() {
	    	// method reads the file and creates the accounts in every line 
	    	// for every user, then adds these accounts to a persons LL_Accounts 
	    	//the persons are added to the Vector in ATM 
	    	try {
	    		Scanner fileScan = new Scanner(new File("C:\\Users\\user\\Desktop\\Spring23\\Objects & Data Abstraction\\Assignment4\\Accounts and Persons.txt"));
	    		//File f = new File("C:\\Users\\user\\Desktop\\Spring23\\Objects & Data Abstraction\\Assignment4\\Accounts and Persons.txt");
	    		//BufferedReader br = new BufferedReader(new FileReader(f));
	    		String line = fileScan.nextLine();
	    		while(line.length() > 0) {
	    			//System.out.println(line);
	    			String[] pers_info = line.split(",");
	    			
	    			//int i = (pers_info.length-2)/2;
	    			
	    			String name = pers_info[0];
	    			String clt_nbr = pers_info[1];
	    			LL_Accounts l = new LL_Accounts();
	    			for(int z = 2;z<pers_info.length;z=z+3) {
	    				String acc_nbr = pers_info[z];
	    				String type = pers_info[z+1];
	    				String balance = pers_info[z+2];
	    				Account acc = new Account(acc_nbr,type,balance);
	    			
	    			l.addAccount(acc);
	    			}
	    			Person p = new Person(name,clt_nbr,l);
	    			list_pers.add(p);
	    			
	    			line = fileScan.nextLine();	    			
	    		}
	    	
	    	}catch(FileNotFoundException e) {
	    		
	    		System.out.println("File was not Found !");
	    	}catch(IOException e) {
	    		System.out.println("Error");
	    	}catch(NoSuchElementException e) {
	    		System.out.println("Bank of Beirut");
	    	}
	    }
	    
	    public void displayPersons() {
	    	for(int i = 0;i<list_pers.size();i++) {
	    		System.out.print(list_pers.get(i));
	    	}
	    }
	    public static int getTime() {
	    	int current_hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	    	return current_hour;
	    }
	    public static boolean timeCond(int time) {
	    	if(time>18)
	    		return false;
	    	else
	    		return true;
	    }
	    public static String getDay() {
	    	Calendar cal = Calendar.getInstance();
	    	int dow = cal.get(Calendar.DAY_OF_WEEK);
	    	if(dow==1)
	    		return "Monday";
	    	else if(dow==2)
	    		return "Tuesday";
	    	else if(dow==3)
	    		return "Wednesday";
	    	else if(dow==4)
	    		return "Thursday";
	    	else if(dow==5)
	    		return "Friday";
	    	else if(dow==6)
	    		return "Saturday";
	    	else
	    		return "Sunday";
	    	
	    }
	    
	    public static Person findPers(String pass) {
	    	// I assumed a person's password is the same as his client number in order to find him in the list
	    	// this does not go against any instruction from Dr azzar
	    	for(int i =0;i<list_pers.size();i++) {
	    		if((list_pers.get(i).getClient_nbr()).equalsIgnoreCase(pass))
	    			return list_pers.get(i);
	    	}
	    	return null;
	    }
	    
	    public static void displayAccount(Person p) {
	    	System.out.println(p);
	    }
	    public void withdraw(Person p,int amount) {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println(p.getAccounts().displayAccounts());
	    	System.out.println("Enter the account number you wish to withdraw from :");
	    	int num = scan.nextInt();
	    	Account a = p.getAccounts().find(num).getAcc();
	    	if(amount<=Integer.parseInt(a.getBalance())) {
	    		int before_withdraw = Integer.parseInt(a.getBalance());
	    		String after_withdraw = String.valueOf(before_withdraw-amount);
	    		a.setBalance(after_withdraw);
	    	}
	    	else {
	    		System.out.println("Insufficient Funds !");
	    	}
	    }
	    public void deposit(Person p,int amount) {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println(p.getAccounts().displayAccounts());
	    	System.out.println("Enter the account number you wish to deposit into :");
	    	int num = scan.nextInt();
	   		Account a = p.getAccounts().find(num).getAcc();
	   		int before_deposit = Integer.parseInt(a.getBalance());
	   		String after_deposit = String.valueOf(before_deposit+amount);
	   		a.setBalance(after_deposit);
    		}
	    
	    public void transfer(Person p,int amount) {
	    	Scanner scan1 = new Scanner(System.in);
	    	System.out.println(p.getAccounts().displayAccounts());
	    	System.out.println("Enter the account number you wish to transfer from ");
	    	int num1  = scan1.nextInt();
	    	Account from = p.getAccounts().find(num1).getAcc();
	    	
	    	Scanner scan2 = new Scanner(System.in);
	    	System.out.println(p.getAccounts().displayAccounts());
	    	System.out.println("Enter the account number you wish to transfer into ");
	    	int num2 = scan2.nextInt();
	    	Account to = p.getAccounts().find(num2).getAcc();
	    	
	    	int before_withdraw = Integer.parseInt(from.getBalance());
    		String after_withdraw = String.valueOf(before_withdraw-amount);
    		from.setBalance(after_withdraw);
    		
    		int before_deposit = Integer.parseInt(to.getBalance());
	   		String after_deposit = String.valueOf(before_deposit+amount);
	   		to.setBalance(after_deposit);
	    }
	    
	    public static void showUser() {
	    	//shows user transactions that are left in the queue
	    	transactions.printQueue();
	    }
	    public void menu() {
	    	// !!!! read comments below regarding time at wich the program will work (before 6) and how to adjust it!!!
	    	Scanner scan = new Scanner(System.in);
	    	//Creates the Persons and their accounts
	    	readInput();
	    	while(true) {
	    		boolean exit = true;
	    		System.out.println("Welcome!");
	    		System.out.println("Enter your identification number :");
	    		String id_num = scan.nextLine();
	    		System.out.println("Enter your password :");
	    		String pass = scan.nextLine();
	    		if(validateInput(id_num,pass)) {
	    			
	    		
	    			while(validateInput(id_num,pass)&&exit) {
	    				System.out.println("1. Withdraw Money\n2. Deposit Money\n3. Transfer of Money\n4. Display Account Info\n5. Exit\n--------------\n Enter your choice:  ");
	    					int choice = scan.nextInt();
					
	    					if(choice==1) {
	    						Scanner scan1 = new Scanner(System.in);
	    						String type = "withdrawl";
	    						String date = getDay();
	    						int time = getTime();
	    						System.out.println("Enter amount you wish to withdraw :");
	    						int amount = scan1.nextInt();
	    						Person p = findPers(pass);
	    						
	    						Transaction t = new Transaction(p,date,time,type,amount);
	    						// This will only run if it's before 6 pm or if you remove the ! before timeCond
	    						if(!timeCond(time)||date.equalsIgnoreCase("sunday")) 
	    							transactions.enqueue(t);
	    						
	    						else
	    							withdraw(p,amount);
	    					}
	    					else if(choice==2) {
	    						Scanner scan2 = new Scanner(System.in);
	    						String type = "deposit";
	    						String date = getDay();
	    						int time = getTime();
	    						System.out.println("Enter amount you wish to deposit :");
	    						int amount = scan2.nextInt();
	    						Person p = findPers(pass);
	    						
	    						Transaction t = new Transaction(p,date,time,type,amount);
	    						// This will only run if it's before 6 pm or if you remove the ! before timeCond
	    						if(!timeCond(time)||date.equalsIgnoreCase("sunday")) {
	    							transactions.enqueue(t);
	    						}
	    						else 
	    							deposit(p,amount);
	    						
	    					}
	    					else if(choice==3) {
	    						Scanner scan3 = new Scanner(System.in);
	    						String type = "transfer";
	    						String date = getDay();
	    						int time = getTime();
	    						System.out.println("Enter the amount you want to transfer :");
	    						int amount = scan3.nextInt();
	    						Person p = findPers(pass);
	    						
	    						Transaction t = new Transaction(p,date,time,type,amount);
	    						// This will only run if it's before 6 pm or if you remove the ! before timeCond
	    						if(!timeCond(time)||date.equalsIgnoreCase("sunday")) {
	    							transactions.enqueue(t);
	    						}
	    						else 
	    							//inside method we will choose the accounts, p is a param just to know wich user so far
	    							transfer(p,amount);
	    					}
	    					
	    					else if(choice==4) {
	    						Person p = findPers(pass);
	    						displayAccount(p);
	    					}
	    					else {
	    						//shows user what transactions are still in the Queue at the end of the day
	    						showUser();
	    						exit = false;
	    					}
	    		}
	    	}
						
				

	    		else {
	    			System.out.println("Invalid credentials!");
	    		}
	    	}
}
	    
	    public static void main(String[]args) {
	    	ATM atm = new ATM(10);
	    	atm.menu();
	    	
	    }
}
