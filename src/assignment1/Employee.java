/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Scanner;


/**
 *
 * @author ztmvf2
 */
public abstract class Employee implements Serializable
{
float rate = 0.0f;
float taxrate = 0.2f;
float hours = 0.0f;
float gross=0.0f;
float tax=0.0f;
boolean taxed = false;
float net=0.0f;
boolean netted = false;
float net_percent=0.0f;
boolean netperc = false;
static Scanner sc = new Scanner(System.in);
private int id;
static NumberFormat cf = NumberFormat.getCurrencyInstance();

Payroll p = new Payroll();
    public Employee()
    {

    }
  
    
    public void computeGross()
    {
    gross = rate * hours;
    }
    
    public void dispGross()
    {
    System.out.println("\nYour gross is: " + cf.format(gross) + "\n");
    
    }
    
    protected void computeTax()
    {
        tax = gross * taxrate;
        System.out.println("\nYour taxes are: " + cf.format(tax) + "\n");
        taxed = true;
    }
    
    protected void computeNet()
    {
        if(taxed = true)
        {
        net = gross - tax;
        System.out.println("\nYour net is:" + cf.format(net) + "\n");
        netted = true;
        }
        else
        {
        System.out.println("\nYou must compute taxes before you can compute net.\n");
        }
    }
    
    protected void computeNetperc()
    {
        if(!taxed)
        {
        System.out.println("\nPlease compute taxes.\n");
        }
        else if(!netted)
        {
        System.out.println("\nPlease compute net.\n");
        }
        else if(taxed && netted)
        {
        net_percent = (net/gross)*100;
        System.out.println("\nYour net percent is:" + net_percent + "%\n");
        netperc = true;
        }
    }
    
    protected void displayEmployee()
    {
        if(taxed && netted && netperc)
        {
        System.out.println("\nHours: " + hours);
        System.out.println("Rate: " + cf.format(rate));
        System.out.println("Gross: " + cf.format(gross));
        System.out.println("Net: " + cf.format(net));
        System.out.println("Net%: " + net_percent + "%\n");
        }
        else if (!taxed)
        {
        System.out.println("\nTaxes need to be computed.\n");
        }
        else if (!netted)
        {
        System.out.println("\nNet gross needs to be calculated first.\n");
        }
        else if (!netperc)
        {
        System.out.println("\nNet percent needs to be calculated first.\n");
        }
        else
        {
        System.out.println("\nPerform the calculations first.\n");
        }
    }

    /**
     * @return the id
     */
    public int getId() 
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
    }
    
    
    

