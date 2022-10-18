package javaapplication9;

public class JavaApplication9
{    
    public static void main(String args[])
    {    
        final Customer d=new Customer();    
        new Thread()
        {    
            public void run()
            {
                d.withdraw(15000);
            }    
        }.start();    
        new Thread()
        {    
            public void run()
            {
                d.deposit(10000);
            }    
        }.start(); 
    }
}  
class Customer
{    
    int bal=10000;    
    synchronized void withdraw(int a)
    {    
        System.out.println("Proceeding to withdraw the Amount...\nAmount to be Withdrawn : "+a);  
        if(bal<a)
        {    
            System.out.println("Low balance\nWaiting for the Deposition...");    
            try
            {
                wait();
            }
            catch(Exception e){}    
        }    
        bal-=a;    
        System.out.println("Withdrawal Complete.\nAvailable Balance : "+bal);    
    }    

    synchronized void deposit(int a)
    {    
        System.out.println("Proceeding to deposit the Amount...\nAmount to be Deposited : "+a);    
        bal+=a;    
        System.out.println("Deposition Completed\nAvailable Balance : "+bal);    
        notify();    
    }    
}    
    
