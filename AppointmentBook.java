/*
* File: AppointmentBook.java
* Descripton:
* Developer: Matthew Carlson
* Email: carlsonm137773@student.vvc.edu
* Date created: 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class AppointmentBook
{
	private ArrayList<Appointment> m_appArray = new ArrayList<Appointment>();

	public AppointmentBook() {}

	public void start()
	{
		boolean running = true; 
		while(running) // loops untill the user is done
		{
			int option = get_int("1. Enter Appointments\n2. Print Appointments for a given day\n3. Print all Appointments\n4. Load Appointments from a file\n5. Save Appointments to a file\n6. Exit\n", 1, 6);
			if(option == 1) // enter appointments
			{
				boolean cont = true;
				while(cont) // allow the user to enter appointments untill they are done
				{
					m_appArray.add(get_appointment());
					int ans = get_int("Enter another appointment? 1 for yes: ");
					if(ans != 1)
						cont = false;
				}
			}
			else if(option == 2) // print appointments for given day
			{
				boolean cont = true;
				while(cont)
				{
					// promt the user for a date using get_int(string prompt, min, max)
					check_date(get_int("Enter day: ", 1, 31),  get_int("Enter month: ", 1, 12), get_int("Enter year:", 1, 9999));

					int ans = get_int("Print appointments for another day? 1 for yes");
					if(ans != 1)
						cont = false;
				}
			}
			else if(option == 3) // print all appointments
			{
				for(int i = 0; i < m_appArray.size(); i++)
				{
					m_appArray.get(i).print();
				}
			}
			else if(option == 4) // load from file
			{
				try
				{
					load(get_string("File name: "));
				}
				catch(FileNotFoundException exception)
				{
					System.out.println("File Not Found");
				}
			}
			else if(option == 5) // save to file
			{
				try
				{
					save(get_string("File name: "));
				}
				catch(FileNotFoundException exception)
				{
					System.out.println("File not Found");
				}
			} 
			else if(option == 6) // exit
			{
				running = false; // sets running to false and ends the while loop
			}
			else
			{
				running = false; // sets running to false and ends the while loop
			}
		}
	}


	/*
		Iterates through the array of appointments calling occursOn on each of the using the date prints out the appointments that match to the user
		@peram app_array the array to iterated through
		@peram day the day
		@peram month the month
		@peram year the year
	*/
	public void check_date(int day, int month, int year)
	{
		for(int i = 0; i < m_appArray.size(); i++)
		{
			if(m_appArray.get(i).occursOn(day, month, year))
				m_appArray.get(i).print();
		}
	}
	
	/*
		Prompts the user for the data needed to create an appointment and returns one
		@peram in the scanner
		@return the appointment entered by the user
	*/
	public Appointment get_appointment()
	{
		int option = get_int("Appointment type\n1. Daily\n2. Monthly\n3. Onetime\n", 1, 3);
		if(option == 1)
			return new Daily(get_string("Descripton: "));
		else if(option == 2)
			return new Monthly(get_int("Day: ", 1, 31), get_string("Description: "));
		else if(option == 3)
			return new Onetime(get_int("Day: ", 1, 31), get_int("Month: ", 1, 12), get_int("Year: ", 1, 9999), get_string("Description: "));

		return new Appointment(); // should never be able to happen
	}
// NOTE: MAKE IT VALID INPUT ONLY ACCEPT AN INT VALUE
	/*
		Prompts the user for a valid number between a min and a max
		@peram in the Scanner
		@peram prompt the prompt output to the user
		@peram min the minimum value allowed
		@peram max the maximum value allowed
		@return the valid int input by the user
	*/
	public int get_int(String prompt, int min, int max)
	{
		Scanner in = new Scanner(System.in);
		int number = 0;

		do
		{
			System.out.print(prompt);
			number = in.nextInt();
			if(number < min || number > max)
				System.out.println("Invalid Input try again. ");
		}
		while(number <  min || number > max );

		return number;
	}
	
	// NOTE CHANGE TO ONLY ALLOW A VALID NUMBER
	/*
		Prompt the user for an int
		@peram in the Scanner
		@peram prompt the message output to the user
		@return the int input by the user
	*/
	public int get_int(String prompt)
	{
	
		Scanner in = new Scanner(System.in);
			System.out.print(prompt);
			int number = in.nextInt();

		return number;
	}

	/*
		Promts the user for a string
		@peram prompt the prompt output to the user
		@return the string input by the user
	*/
	public String get_string(String prompt)
	{
		Scanner in = new Scanner(System.in);
		System.out.println(prompt);
		return in.nextLine();
	}

	/*
		Saves an array of Appointments to a file
		@peram String file_name the name of the file to save the appointments to
		@peram app_array the array of Appointments
	*/
	public void save(String file_name) throws FileNotFoundException

	{	
		PrintWriter out = new PrintWriter(file_name);

		for(int i = 0; i < m_appArray.size(); i++)
		{
			out.println(m_appArray.get(i).out_string());
			System.out.println(m_appArray.get(i).out_string());
		}
		out.close();
	}
	
	/*
		Loads appointments from a file and adds the to an array
		@peram file_name the file to load the data from
		@peram app_array the array to add the data to
	*/
	public void load(String file_name) throws FileNotFoundException 
	{
		File input = new File(file_name);
		Scanner in = new Scanner(input);
		while(in.hasNext()) // loop until end of file
		{
			// Parse current line
			String line = in.nextLine();
			Scanner current_line = new Scanner(line);
			String type = current_line.next();
			// check data type and create the correct type of appointment	
			if(type.compareTo("Daily") == 0)
				m_appArray.add(new Daily(current_line.nextLine().trim()));
			else if(type.compareTo("Monthly") == 0)
				m_appArray.add(new Monthly(current_line.nextInt(), current_line.nextLine().trim()));
			else if(type.compareTo("Onetime") == 0)
				m_appArray.add(new Onetime(current_line.nextInt(), current_line.nextInt(), current_line.nextInt(), current_line.nextLine().trim()));
		}
		in.close();
	}

}
