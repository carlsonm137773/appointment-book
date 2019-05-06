/*
* File: Appointment.java
* Descripton:
* Developer: Matthew Carlson
* Email: carlsonm137773@student.vvc.edu
* Date created: 04/27/2019
*/

public class Appointment
{
	private String m_description;
	public Appointment()
	{}

	/*
		Sets the description
		@peram _des the new description
	*/
	public void set_description(String _des)
	{
		m_description = _des;
	}
	
	/*
		Gets the description
		@return m_description
	*/
	public String get_description()
	{
		return m_description;	
	}

	public String out_string()
	{
		return "Error created from base class Appointment";
	}

	public boolean occursOn(int _day, int _month, int _year)
	{
		return false;
	}

	public void print()
	{
		System.out.println("Error created from base class appointment");
	}
}

