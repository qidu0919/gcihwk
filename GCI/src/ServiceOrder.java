import java.time.Month;

public class ServiceOrder extends Invoice{
	double recurringCost; // remote site VPN
	double nonRecurringCost; // configuration and testing of equipment
	ServiceOrder(int id, String type, char typeOfContract, double payrate, int year, Month month, int day,
			int lengthOfContract, double nonRecurringCost) {
		super(id, type, typeOfContract, payrate, year, month, day, lengthOfContract);
		this.nonRecurringCost = nonRecurringCost;
		this.recurringCost = payrate; 
		// TODO Auto-generated constructor stub
	}

}
