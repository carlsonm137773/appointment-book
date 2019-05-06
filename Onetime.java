/*
* File: Onetime.java
* Descripton: Onetime appointment
* Developer: Matthew Carlson
* Email: carlsonm137773@student.vvc.edu
* Date created: 04/27/2019
*/

public class Onetime extends Appointment
{
	private int m_day;
	private int m_month;
	private int m_year;

	/*
		constructor
	*/
	public Onetime(int _day, int _month, int _year, String _description)
	{
		m_day = _day;
		m_month = _month;
		m_year = _year;
		this.set_description(_description);
	}
	
	/*
		checks if the Onetime appointment occours on the given date
	*/
	public boolean occursOn(int _day, int _month, int _year)
	{
		if((m_day == _day) && (m_month == _month) && (m_year == _year))
			return true;
		else
			return false;
	}

	/*
		Prints the appointment to the screen

		NOTE: can I just send it to an output stream type thing? Would be better for file output
	*/
	public void print()
	{
		System.out.println(this.get_description());// prints out the appointment
	}

	/*

	*/
	public String out_string()
	{
		return "Onetime " + m_day + " " + m_month + " " + m_year + " " + this.get_description();
	}
}

