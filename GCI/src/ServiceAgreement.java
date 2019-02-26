import java.time.Month;

public class ServiceAgreement extends Invoice{
	
	String projectSummary; // remote site VPN
	String scopeOfWork; // configuration and testing of equipment
	ServiceAgreement(int id, String type, char typeOfContract, double payrate, int year, Month month, int day,
			int lengthOfContract, String projectSummary, String scopeOfWork) {
		super(id, type, typeOfContract, payrate, year, month, day, lengthOfContract);
		this.projectSummary = projectSummary;
		this.scopeOfWork = scopeOfWork; 
		// TODO Auto-generated constructor stub
	}

}
