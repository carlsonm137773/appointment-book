
/*
* File: Monthly.java
* Descripton: Monthly appointment type
* Developer: Matthew Carlson
* Email: carlsonm137773@student.vvc.edu
* Date created: 04/27/2019
*/

public class Monthly extends Appointment
{
	private int m_day;

	/*
		Constructor
	*/
	public Monthly(int _day, String _description)
	{
		m_day = _day;
		this.set_description(_description);
	}

	/*
		Checks if the Monthly appointment occours on the given date
	*/
	public boolean occursOn(int _day, int _month, int _year)
	{
		if(m_day == _day)
			return true;
		else
			return false;
	}

	/*
		Prints the appointment to the screen
	*/
	public void print()
	{
		System.out.println(this.get_description());// prints out the appointment
	}

	/*

	*/
	public String out_string()
	{
		return "Monthly " + m_day + " " + this.get_description(); 
	}
}
