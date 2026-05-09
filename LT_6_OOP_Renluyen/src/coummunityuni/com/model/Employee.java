package coummunityuni.com.model;

public class Employee extends StaffMember {


	protected String socialSecurityNumber;
	protected int payRate;
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public int getPayRate() {
		return payRate;
	}
	public void setPayRate(int payRate) {
		this.payRate = payRate;
	}
	public String toString() {
		return super.toString() +"--"+ "socialSecurityNumber" + "--" + "payRate";
	}
	public double pay() {
		return 500;
	}

}
