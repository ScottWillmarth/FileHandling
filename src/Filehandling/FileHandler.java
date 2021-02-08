package Filehandling; 
import java.io.*;
import java.util.Scanner;

public class FileHandler {
	
	public static void readFile(File f)
	{
		BufferedReader in;
		try 
		{
			in = new BufferedReader(new FileReader(f));
			
			String s = in.readLine();
			if(s == null)
			{
				System.out.println("File is empty");
			}
			while(s != null)
			{
				System.out.println("Read: " + s);
				s = in.readLine();
			}
			in.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static void writeFile(File f)
	{
		BufferedWriter out;
		try 
		{
			out = new BufferedWriter(new FileWriter(f));
			System.out.println("Writing Something");
			out.write("Something \n");
			out.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static void appendFile(File f)
	{
		try 
		{
			PrintWriter app = new PrintWriter(new FileWriter(f, true));
			@SuppressWarnings("resource")
			Scanner myScan = new Scanner(System.in);
			System.out.println("Please add the text to append");
		    String input = myScan.nextLine();
		    app.append(input.toString() +"\n");
		    
		    System.out.println("Add additional text? (Type NO to quit");
		    input = myScan.nextLine();
		    while(!input.equals("NO"))
		    {
		    	app.append(input.toString() +"\n");
			    System.out.println("Add additional text? (Type NO to quit");
			    input = myScan.nextLine();
		    }
		    app.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("Please type in a file to use (Remember to add the file extension)");
	    String input = myScan.next();
	    File f = null;
	    try
	    { 
            f = new File(input); 
  
            if (f.createNewFile())
            {
            	System.out.println("File created"); 
            }
                
            else
            { 
            	System.out.println("File already exists"); 
            }
        } 
        catch (Exception e) {System.err.println(e);} 
		
		readFile(f);
		writeFile(f);
		appendFile(f);

	}
}
