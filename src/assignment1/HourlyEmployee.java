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
public class HourlyEmployee extends Employee implements Serializable
{
    @Override
    public void computeGross()
    {
    System.out.println("\nPlease enter hours worked: ");
    hours = sc.nextFloat();
    System.out.println("\nPlease enter rate: ");
    rate = sc.nextFloat();
    
        if(hours <= 40)
        {
        gross = hours * rate;
        
        }
        else if(hours > 40)
        {
        float leftover = hours - 40;
        gross = (40 * rate) + (leftover * (rate * 1.5f));
        
        }
    
    }
    
}
