import java.time.LocalDate;
import java.time.Month;
//import java.util.ArrayList;

public class Invoice {
	int id;
	String status ;
	String type ;
	double payrate; 
	int year= 1; 
	int day = 1;
	Month month = Month.JANUARY;
	char typeOfContract; // M for monthly, H for hourly
	int lengthOfContract;
	LocalDate beginningDate;
	LocalDate endingDate;
	Invoice (int id, String type, char typeOfContract, double payrate, 
			int year, Month month, int day, int lengthOfContract){
		this.id =id;
		this.type =type;
		this.typeOfContract =typeOfContract;
		this.payrate = payrate;
		this.year = year;
		this.month = month;
		this.day = day; 
		this.lengthOfContract =lengthOfContract;
		beginningDate = LocalDate.of(year,month,day);
		endingDate = beginningDate.plusDays(lengthOfContract);
	}
	
	public void refreshStatus () {
		LocalDate rightNow = LocalDate.now();
		LocalDate rightNow90 = rightNow.plusDays(90);
		
		if (rightNow.isAfter(endingDate) && status != "PAID") {
			status = "PAST DUE";
			return;
		} else if (rightNow90.isAfter(endingDate)) {
			status = "DUE SOON"; // or EXPIRING
		}
		
	}
	

}


