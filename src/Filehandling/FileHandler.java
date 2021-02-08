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

	}

}
