import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wesley Roberts 30401561
 * This class is to validate some of the user entries to ensure
 * "Correct Data" is passed into the system
 * This was just done as something extra as I'm not sure it is within the scope
 * of the assignment
 *
 */
public class InputValidation {
	public static boolean isValidDate(String inputDate)
	{
		if(inputDate.trim().equals(""))
		{
			System.out.println("Invalid Entry");
			return false;
		}
		else
		{
			SimpleDateFormat format = new SimpleDateFormat("d/M/yy");
			format.setLenient(false);
			
			try
			{
				Date date = format.parse(inputDate);
			}
			catch (ParseException e)
			{
				System.out.println("Invalid Entry");
				return false;
			}
			return true;
		}
	}
	
	public static boolean isValidPhoneNumber(String inputString)
	{
		inputString = inputString.replaceAll("\\s+", "");
		
		if(inputString.startsWith("04") && inputString.length() == 10)
		{
			try
			{
				int number = Integer.parseInt(inputString);
				return true;
			}
			catch (NumberFormatException e)
			{
				
			}
		}
		
		System.out.println("Invalid Entry");
		return false;
	}
	
	public static boolean isValidTime(String inputString)
	{
		if(inputString.trim().equals(""))
		{
			System.out.println("Invalid Entry");
			return false;
		}
		else
		{
			SimpleDateFormat format = new SimpleDateFormat("h:mm a");
			format.setLenient(false);
			
			try
			{
				Date date = format.parse(inputString);
				
			}
			catch (ParseException e)
			{
				System.out.println("Invalid Entry (Example: 1:00 pm");
				return false;
			}
			return true;
		}
	}
}
