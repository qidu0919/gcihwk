import java.time.Month;
import java.util.ArrayList;
public class User {
	int id;
	String name;
	int contractCount;
	int siteCount;
	double totalPerMonth;
	int warningnum;
	ArrayList <Invoice> invoices = new ArrayList<Invoice>();
	User (String name, int id){
		this.id = id;
		this.contractCount =0;
		this.siteCount =0;
		this.totalPerMonth =0;
		this.warningnum = 0;
	}
	public void addContract(Invoice contract) {
		for ( int i = 0; i <invoices.size(); i++) {
			if(invoices.get(i).id == contract.id) {
				System.out.println("Already In System");
				return;
			}
		}
		invoices.add(contract);
		contractCount++;
		if (contract.status == "PAST DUE" ||contract.status == "DUE SOON") {
			warningnum++;
		}
		if (contract.type == "C") {
			siteCount = siteCount + ((Contract)contract).sites.size();
			totalPerMonth = totalPerMonth + contract.payrate; 
			
		} else if (contract.type == "S") {
			siteCount ++;
			totalPerMonth = totalPerMonth + contract.payrate; 
		} else {
			return;
		}
	}
	public void payContract( int id) {
		for ( int i = 0; i <invoices.size(); i++) {
			if(invoices.get(i).id == id) {
				invoices.get(i).status = "Paid";
				if (invoices.get(i).status == "PAST DUE" ||invoices.get(i).status == "DUE SOON") {
					warningnum--;
				}
				if (invoices.get(i).type == "C") {
					siteCount = siteCount - ((Contract)invoices.get(i)).sites.size();
					totalPerMonth = totalPerMonth - invoices.get(i).payrate; 
					
				} else if (invoices.get(i).type == "S") {
					siteCount --;
					totalPerMonth = totalPerMonth - invoices.get(i).payrate; 
				} else {
					return;
				}
				return;
			} 
		}
		System.out.println("Invalid ID");
		
	}
	public static void main(String arg []) {
		User wayne = new User("Wayne", 1);
		Contract first1 = new Contract(123, "C", 'C', 20.01, 2019, Month.JANUARY, 23, 160);
		first1.addSite("site1", "100mb Internet", 7000);
		first1.addSite("site1", "100mb Internet", 7000);
		first1.addSite("site1", "100mb Internet", 7000);
		first1.addSite("site1", "100mb Internet", 7000);
		first1.addSite("site1", "100mb Internet", 7000);
		first1.sumOfPayRate();
		first1.refreshStatus();
		ServiceOrder first2 = new ServiceOrder(124, "S", 'S', 20.01, 1950, Month.JANUARY, 23, 160, 8000);
		first2.refreshStatus();
		ServiceAgreement first3 = new ServiceAgreement(125, "SO", 'C', 20.01, 1950, Month.JANUARY, 23, 160, "HI", "Hi");
		first3.refreshStatus();
		wayne.addContract(first1);
		wayne.addContract(first2);
		wayne.addContract(first3);
		wayne.payContract(123);
		wayne.payContract(124);
		
		System.out.println(wayne.contractCount);
		System.out.println(wayne.siteCount);
		System.out.println(wayne.totalPerMonth);
		System.out.println(wayne.warningnum);
		
		
	}
}
