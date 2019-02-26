import java.time.Month;
import java.util.ArrayList;

public class Contract extends Invoice{
	
	ArrayList <String> sites = new ArrayList<String>(); 
	ArrayList <String> service = new ArrayList<String>(); 
	ArrayList <Double> monthlyPrice = new ArrayList<Double>(); 
	public void addSite(String siteName, String serviceName, double mp) {
		sites.add(siteName);
		service.add(serviceName);
		monthlyPrice.add(mp);
	}
	public String printSite(String siteName) {
		for ( int i =0; i<sites.size(); i++) {
			if (sites.get(i) == siteName ) {
				return sites.get(i) +" "+ service.get(i)+" "+ monthlyPrice.get(i); 
			}
			
		}
		return "None";
	}
	public  void sumOfPayRate() {
		double sums = 0;
		for (int i = 0; i<monthlyPrice.size();i++) {
			sums = sums+ monthlyPrice.get(i);
		}
		payrate = sums;
	}
	
	Contract(int id, String type, char typeOfContract, double payrate, int year, Month month, int day,
			int lengthOfContract) {
		super(id, type, typeOfContract, payrate, year, month, day, lengthOfContract);
		// TODO Auto-generated constructor stub
	}
	
}