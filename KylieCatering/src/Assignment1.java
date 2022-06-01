import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Wesley Roberts
 *	Main class that is utilized to gain user input and
 *modify the constructor catering class
 */
public class Assignment1 
{
	public static void main(String[] args) 
	{
		int k = 0;
		String multipleOrders = "n";
		CateringBooking[] booking = new CateringBooking[5];
		DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
		
		System.out.println("Kylie's Catering Service");
		
		//Loop to create multiple booking objects in 1 session that can be separated into arrays
		do
		{
			//invoke method to create new booking stored in array 
			//to allow for multiple bookings in one array
			booking[k] = bookingInfo();			
			
			boolean check = true;
			int[] addToOrder = new int[6];
			int[] quantity = new int[6];
			double[] itemCalculation = new double[6];
			int j = 0;
			
			//Loop to create one booking
			while(check && j < 6)
			{
				printMenuOptions(booking[k]);
				
				addToOrder[j] = getIntResponse("What would you like to add to the booking order: ");
				
				//checking that the add to order is one of the menu options else end booking session
				if(addToOrder[j] > 0 && addToOrder[j] < 10)
				{
					quantity[j] = getIntResponse("How many " + booking[k].menuItems[addToOrder[j] - 1] + " would you like: ");
					itemCalculation[j] = (booking[k].itemPrice[addToOrder[j] - 1] * quantity[j]);
					booking[k].changePrice(addToOrder[j], quantity[j]);
					j++;
				}
				else
				{
					check = false;
					System.out.println("\n" + booking[k].printBooking());
				}
				
				/*
				 * Output formatting to ensure that if the limit of 6 orders is placed then
				 * the "Finalising Booking" output will be printed prior to the "Ordered Items" output
				 */				
				if(j == 6)
				{
					System.out.println("\nLimit of 6 items reached!");
					System.out.println(booking[k].printBooking());
				}
				
				System.out.println("\nOrdered items: ");
				for (int i = 0; i < j; i++)
				{
					System.out.format("%-60s %10s%n", " " + quantity[i] + " x " + booking[k].menuItems[addToOrder[i] - 1], decimalFormat.format(itemCalculation[i]));
				
				}
				System.out.println("Total cost (includes $25 fee): $" + decimalFormat.format(booking[k].getPrice()) + "\n");
			}
			
			System.out.println("Thank you.");
			
			//Check if the user wants to make another booking if they do make some space in the console and start over
			multipleOrders = getStringResponse("Do you want to enter another booking for another event? (y/n): ");
			if(multipleOrders.contains("y"))
			{
				System.out.println("\n\n\n\n\n\n\n\n\n");
				k++;
			}
			
			
		}while(multipleOrders.contains("y"));
		
		//Print out all the orders made in this session
		if(k > 0)
		{
			for(int i = 0; i <= k; i++)
			{
				System.out.println();
				System.out.println(booking[i].printBooking());
			}
		}
		
	}
	
	//Method to return string values placed by the user
	public static String getStringResponse(String output) 
	{
		System.out.print(output);
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		return input;
	}
	
	//Method to return int values placed by the user
	public static int getIntResponse(String output) 
	{
		System.out.print(output);
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		return input;
	}
	
	//Method to print all the menu options utilizing the array in the Catering Class
	public static void printMenuOptions(CateringBooking booking)
	{
		System.out.println("The following are options you can add to your catering booking order: ");
		for (int i = 0; i < booking.menuItems.length; i++) {
			System.out.println((i+1) + ". " + booking.menuItems[i] + "" );
		}
		System.out.println("0. Finished making Selections");
	}
	
	//Method to invoke and return a new Booking Object with the values entered by the user
	public static CateringBooking bookingInfo()
	{
		boolean check = false;
		String cateringDate;
		String cateringTime;
		String customerPhone;
		
		String customerName = getStringResponse("Please enter the name of the person/organisation making a booking: ");
		
		do
		{
			cateringDate = getStringResponse("What is the date the catering is required (d/M/yy): ");
			check = InputValidation.isValidDate(cateringDate);
		}while(check == false);
		
		do 
		{
			cateringTime = getStringResponse("What is the time the catering is required (h:mm a): ");
			check = InputValidation.isValidTime(cateringTime);
		}while(check == false);
		
		String cateringAddress = getStringResponse("What is the address to deliver to: ");
		
		do
		{
			customerPhone = getStringResponse("What is a mobile phone number for the organiser: ");
			check = InputValidation.isValidPhoneNumber(customerPhone);
		}while(check == false);
		
		System.out.println("Thank you. \n");
		return new CateringBooking(customerName, cateringDate, cateringTime, cateringAddress, customerPhone);
	}
}
