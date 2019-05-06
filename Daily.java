/*
* File: Daily.java
* Descripton: Daily appointment 
* Developer: Matthew Carlson
* Email: carlsonm137773@student.vvc.edu
* Date created: 04/27/2019
*/

public class Daily extends Appointment
{
	/*
		Constructor
	*/
	public Daily(String _description)
	{
		this.set_description(_description);
	}

	/*
		Always true appointment happens every day
	*/
	public boolean occursOn(int _day, int _month, int _year)
	{
		return true;
	}

	/*
		Prints stuff
	*/
	public void print()
	{
		System.out.println(this.get_description());// prints out the appointment
	}

	/*
		
	*/
	public  String out_string()
	{
		return "Daily " + this.get_description(); 
	}
}

