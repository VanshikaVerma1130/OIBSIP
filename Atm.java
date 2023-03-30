//NAME:VANSHIKA VERMA
//ATM INTERFACE
//the user is prompted to enter user id and user pin(register and login). On successful login ATM functionalities are unlocked.
//then the user can perform operations like withdraw,deposit or transfer money,check balance and view the transaction history.

import java.util.*;

class AtmInterface{                                     
	String userid;
	int userpin;
	float balance=0;
	int no_transaction=0;
	String transHistory="";
	
	public void registration() {                       //step1: Register into ATM interface
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your userid");
		this.userid=sc.nextLine();
		System.out.println("enter your userpin");
		this.userpin=sc.nextInt();
		System.out.println("you are registered!");
	}
	
	public int login() {                            //Step2: Login with registered details
		int valid=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your userid");
		String id=sc.nextLine();
		System.out.println("enter your userpin");
		int pin=sc.nextInt();
		if((id.equals(userid))&&(pin==userpin)) {
			System.out.println("login successful!");
		    System.out.println("now you can continue");
		}
		else {
			System.out.println("Invalid details! \nplease enter correct user id or user pin");
			valid=0;
		}
		return valid;
		
   }
	
	public void viewBalance() {                    //operation1: Check the balance in your account
		System.out.println("your current balance is:"+ balance);
	}
	
	public void withdrawMoney() {                 //operation2: Withdraw money from the account
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the amount you want to withdraw");
		float withdraw=sc.nextInt();
		if(balance>withdraw) {
		    balance=balance-withdraw;
		    String s="withdrawn amount is:";
            transactionHistory(s, withdraw);
		    no_transaction++;
		}
		else
			System.out.println("you don't have enough balance to withdraw");
	}
	
	public void depositMoney() {                //operation3: Deposit money into the account
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the amount you want to deposit");
		float deposit=sc.nextInt();
		balance=balance+deposit;
        String s="deposited amount is:";
		transactionHistory(s, deposit);
		no_transaction++;
	}
	
	public void transferMoney() {             //operation4: Transfer money from the account
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the amount you want to transfer");
		float transfer=sc.nextInt();
		if(balance>transfer) {
			balance=balance-transfer;
            String s="transfered amount is:";
			transactionHistory(s, transfer);
			no_transaction++;
		}
		else
			System.out.println("you don't have enough balance to transfer money");
	}
	

   public void transactionHistory(String s, float amount) {        //preparing the transaction history of the account
	   String str= s+amount+" ";
	   transHistory=transHistory.concat(str);
   }
   
   public void printTransHistory() {                              //operation5: print the transaction history of the account
	   if(no_transaction==0)
			System.out.println("no transaction of money");
		else
			System.out.println("your transaction history is:"+transHistory);
  }
   
}


public class ATM {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AtmInterface atm= new AtmInterface() ;
		System.out.println("ATM INTERFACE");
		atm.registration();                   // call to registration function
		int valid=atm.login();                // call to login function
		while(valid==0) {                     //user is prompted to enter user id and user pin till the details are incorrect 
			valid=atm.login();
		}
			
		char ch='y';
		while((ch=='y'||ch=='Y')&&(valid==1)) {
		System.out.println("enter your choice to perform the following opeartions:");
		System.out.println("\n 1.Check balance\n 2.Withdraw\n 3.Deposit\n 4.Transfer\n 5.Transaction history\n 6.Quit");
        int choice=sc.nextInt();
        switch(choice) {                      
        case 1:
        	atm.viewBalance();                //call to viewBalance function
        	System.out.println("want to continue?(y/n)");
        	ch=sc.next().charAt(0);
        	break;
        case 2:
        	atm.withdrawMoney();              //call to withdrawMoney function
        	System.out.println("want to continue?(y/n)");
        	ch=sc.next().charAt(0);
        	break;
        case 3:
        	atm.depositMoney();               //call to depositMoney function
        	System.out.println("want to continue?(y/n)");
        	ch=sc.next().charAt(0);
        	break;
        case 4:
        	atm.transferMoney();              //call to transferMoney function
        	System.out.println("want to continue?(y/n)");
        	ch=sc.next().charAt(0);
        	break;
        case 5:
        	atm.printTransHistory();         //call to transactionHistory function
        	atm.viewBalance();
        	System.out.println("want to continue?(y/n)");
       	    ch=sc.next().charAt(0);
      	    break;
        case 6:
        	System.out.println("thankyou for coming!");
        	break;
        
        }
		
      }
		
        
		
	}

}

