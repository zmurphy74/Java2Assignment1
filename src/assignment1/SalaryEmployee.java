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
public class SalaryEmployee extends Employee implements Serializable
{
    @Override
    public void computeGross()
    {
        
        System.out.println("\nAre you staff or executive? Use an (1) for staff or an (2) for executive: ");
        int selection = sc.nextInt();
        
        if(selection == 1)
        {
        System.out.println("\nAs a staff employee your salary is $50,000.\n");
        gross = 50000;
        }
        else if(selection == 2)
        {
        System.out.println("\nAs an executive employee your salary is $100,000.\n");
        gross = 100000;
        }
        else if(selection != 1 || selection != 2)
        {
        System.out.println("\nPlease enter a number that corresponds to the prompt.\n");      
        }
    
    }
    
}
