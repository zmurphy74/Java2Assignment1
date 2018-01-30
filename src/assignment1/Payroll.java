/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;


import static assignment1.Employee.sc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ztmvf2
 */
public class Payroll implements Serializable 
{
    int counter = 0;
    int shenanigans;
    int derp = -1;
    boolean alreadyExecuted = false;
    ArrayList<Employee> earray = new ArrayList<>();
    
    public static void main(String[] args) 
    {
    Payroll pr = new Payroll();
    pr.menu();
    }
    
    public void menu()
    {
    System.out.println("\n1. Populate Employees \n2. Select Employee \n3. Save Employees \n4. Load Employees \n5. Exit ");
    int d = sc.nextInt();
            switch (d)
            {
                case (1):
                {
                    //Populate
                    if(!alreadyExecuted)
                    {
                    populate();
                    menu();
                    }
                        else
                        {
                        System.out.println("\nEmployees already populated, would you like to add to the existing employees? (Y) or (N)\n");
                        String ch = sc.next();
                            if(ch.equalsIgnoreCase("y"))
                            {
                            //shenanigans = earray.size();
                            //counter = earray.size();
                            populate();
                            menu();
                            }
                            else
                            {
                            menu();
                            }
                        }
                    break;
                }
                case 2:
                {   
                    //Select
                    //select();
                    pickEmp();
                    break;
                }
                case 3:
                {
                //Save
                    if(!alreadyExecuted)
                    {
                    System.out.println("\nThere is nothing to save.\n");
                    menu();
                    }
                    else
                    {                      
                        try
                        {
                            try (FileOutputStream file = new FileOutputStream("Employee.txt")) 
                            {
                                ObjectOutputStream output = new ObjectOutputStream(file);
                                output.writeObject(earray);
                                output.flush();
                                menu();
                            }
                        }                       
                        catch(IOException e)
                        {
                        System.out.println(e);
                        }
                        
                    }
                    
                    break;
                }
                case 4:
                {
                    //Load 
                    try
                    {
                    try (FileInputStream file = new FileInputStream("Employee.txt")) 
                    {
                        ObjectInputStream input = new ObjectInputStream (file);
                        earray = (ArrayList<Employee>)input.readObject();
                        shenanigans = earray.size();
                        counter = earray.size();
                    }
                    alreadyExecuted = true;
                    }
                    catch(IOException e)
                    {
                    System.err.println("\nAn error was encounter please try again.\n");
                    menu();
                    }
                    catch(ClassNotFoundException cnfe)
                    {
                    System.err.println("\nFile to load accounts was not found.\n");
                    menu();
                    }
                    loadedmenu();
                    break;
                }
                case 5:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("\nEnter a number that corresponds to the menu.\n");
                    menu();
                }
            }
        }
    public void populate()
        {
            for(int i=counter; i <= earray.size(); i++)
                {
                    System.out.println("\nPlease enter (C)Commission, (S)Salary, (H)Hourly, or (D) to quit: ");
                        
                    String input = sc.next();
                   
                    
			if(input.equalsIgnoreCase("C"))
                        {
                            System.out.println("Enter your ID#:");
                            int id = sc.nextInt();
                            earray.add(i, new CommissionEmployee());
                            //System.out.println("\nYour ID# is: " + id + "\n");
                            earray.get(i).setId(id);
                            earray.get(i).computeGross();
                            
                            counter++;
                            
                        }
                        else if(input.equalsIgnoreCase("S"))
                        {
                            System.out.println("Enter your ID#:");
                            int id = sc.nextInt();
                            earray.add(i, new SalaryEmployee());
                            //System.out.println("\nYour ID# is: " + i + "\n");
                            earray.get(i).setId(id);
                            earray.get(i).computeGross();
                            counter++;
                            
                        } 
                        else if(input.equalsIgnoreCase("H"))
                        {
                            System.out.println("Enter your ID#:");
                            int id = sc.nextInt();
                            
                            earray.add(i, new HourlyEmployee());
                            //System.out.println("\nYour ID# is: " + i +"\n");
                            earray.get(i).setId(id);
                            earray.get(i).computeGross();
                            counter++;
                        }
                        else if(input.equalsIgnoreCase("D"))
                        {
                        alreadyExecuted = true;
                        menu();
                        }
                        else if(!"H".equalsIgnoreCase(input)||!"S".equalsIgnoreCase(input)||!"C".equalsIgnoreCase(input)||!"D".equalsIgnoreCase(input))
                        {
                        System.out.println("Enter a letter that corresponds to the options.");
                        i--;
                        }          
		}         
        }
    public void select()
        {
            System.out.println("\nPlease enter your ID#: ");
            int id = sc.nextInt();
            
                if(id > 0 && earray.size() >= id)
                {
                    System.out.println("\nThat ID does not exist.\n");
                    menu();
                }
                else
                {
                   
                    earray.get(id);
                    
                    shenanigans = id;
                    
                    topmenu();
                }

        }
    public void topmenu()
        {
            System.out.println("\n1) Calculate Gross Pay\n2) Calculate Tax\n3) Calculate Net Pay\n4) Calculate Net Percent\n5) Display Employee\n6) Exit ");
            int in = sc.nextInt();

                switch (in)
                {
                case 1:
                earray.get(derp).dispGross();
                topmenu();
                break;
                case 2:
                earray.get(derp).computeTax();
                topmenu();
                break;
                case 3:
                earray.get(derp).computeNet();
                topmenu();
                break;
                case 4:
                earray.get(derp).computeNetperc();
                topmenu();
                break;
                case 5:
                earray.get(derp).displayEmployee();
                topmenu();
                break;
                case 6:
                menu();
                break;
            
                default:
                System.out.println("\nEnter a number that corelates to the menu.\n");           
                }          
        }
    public void loadedmenu()
        {
            System.out.println("\nWould you like to add accounts to this file? (Y) or (N)\n");
            String ch = sc.next();
            counter  = earray.size();
            shenanigans = earray.size();
                if(ch.equalsIgnoreCase("y"))
                {
                    populate();
                }
                else if(ch.equalsIgnoreCase("n"))
                {
                    menu();
                }
                else
                {
                    System.out.println("Enter a proper input.");
                }
            
            
        }
    public void pickEmp()
    {
        
        
        System.out.println("Enter your ID#:");
        int id = sc.nextInt();
        for(int i = 0; i < earray.size(); i++)
        {
            
            if(earray.get(i).getId() == id)             
            {
            derp = i;
            topmenu();
            }
//            else
//            {
//            System.out.println("Your ID was not found.");
//            }
       
        }
        if(derp == -1)
        {
        System.out.println("ID is not found.");
        menu();
        }
        menu();
    }

}    

