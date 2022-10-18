package exp81;
import java.util.*;
public class Exp81 {

    public static void main(String[] args) {
        Scanner o = new Scanner(System.in);
        gnum g = new gnum();
        g.start();
    }  
}

class gnum extends Thread
{
    Thread t = new Thread();
    Scanner o = new Scanner(System.in);
    int arn[] = new int[50];
    public void run()
    {
        int n;
        System.out.print("\nEnter the value of N : ");
        n = o.nextInt();
        int j=0;
        pfiv p = new pfiv();
        avge v = new avge();
        try
        {
            for(int i=0;i<n;i++)
            {
                System.out.print("Enter the Value : ");
                arn[i] = o.nextInt();
                p.dt(arn[i],i);
                v.dta(arn[i],i);
                j=i;
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            System.out.print("\nThe Program has been TERMINATED!!!!  ");
        }
        if((j+1)==n)
        {
            p.start();
        }
        if(j==(n-1))
            v.start();
    }
}

class pfiv extends Thread
{
    int ar[]=new int[50];
    int q;
    public void dt(int a,int i)
    {        
        ar[i] = a;
        q=i;
    }
    public void run()
    {
        avge v = new avge();
        int t;
        try
        {
        for(int i=0;i<=q;i++)
        {
            t=ar[i]%5;
            if(t==0)
            {
                System.out.print("Number Divisible by 5 is : "+ar[i]+"\n");
            }
        }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }        
    }
}

class avge extends Thread
{    
    public void dta(int a,int i)
    {        
        ar[i] = a;
        q=i;
    }
    int ar[] = new int[50];
    int q;
    public void run()
    {
        int tot=0,te,i=0;
        while(i<=q)
        {
            te = ar[i];            
            tot = tot + te;
            i=i+1;
        }
        System.out.print("\nThe Total value is : "+tot);
        int t=tot/(q+1);
        System.out.print("\nThe Average value is : "+t+"\n");
    }
}

