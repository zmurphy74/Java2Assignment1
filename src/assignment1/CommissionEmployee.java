/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.io.Serializable;

/**
 *
 * @author ztmvf2
 */
public class CommissionEmployee extends Employee implements Serializable
{

 
@Override
public void computeGross()
{
    System.out.println("\nPlease enter the number of items sold: ");
    float items = sc.nextFloat();
    System.out.println("\nPlease enter the unit price of item sold: ");
    float price = sc.nextFloat();
    gross = (items * price)/2;
}
        
}
