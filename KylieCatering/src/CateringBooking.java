
/**
 * @author Wesley Roberts 30401561
 * Constructor class for use in the catering business
 *
 */
public class CateringBooking 
{
	//Fields
	private String customerName;
	private String cateringDate;
	private String cateringTime;
	private String cateringAddress;
	private String customerPhone;
	private double price = 25.0;
	public String[] menuItems = {"Assorted Meat Cut Sandwiches (3.30 per sandwich)", 
			"Assorted Salad Cut Sandwiches (3.20 per sandwich)", 
			"Cooked Chicken Arancini Balls (2.40 each)",
			"Mini Quiches (3.75 each)", 
			"Mini Sausage rolls (3.50 each)",
			"Mini Party Pies (4.20 each)",
			"Fruit Platter (20.25 for each platter)",
			"Cake Slices (21.10 for each set of 10 slices)",
			"Scones (2.30 each)"};
	public double[] itemPrice = {3.30, 3.20, 2.40, 3.75, 3.50, 4.20, 20.25, 21.10, 2.30};

	//Constructor
	public CateringBooking(String name, String date, String time, String address, String phone) 
	{
		customerName = name;
		cateringDate = date;
		cateringTime = time;
		cateringAddress = address;
		customerPhone = phone;
	}
	
	public String getName()
	{
		return customerName;
	}
	
	public String getDate()
	{
		return cateringDate;
	}

	public String getTime()
	{
		return cateringTime;
	}
	
	public String getAddress()
	{
		return cateringAddress;
	}
	
	public String getPhone()
	{
		return customerPhone;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void changePrice(int itemChoice, int quantity)
	{
		price += (quantity * itemPrice[itemChoice - 1]);
	}
	
	public String printBooking()
	{
		String bookingInfo = "Finalising catering booking order:\n" +
				"Catering booking for " + customerName + " for " + cateringDate + " at " + cateringTime +
				"\nDeliver to: " + cateringAddress +
				"\nOrganiser Phone: " + customerPhone;
		return bookingInfo;
	}
}
