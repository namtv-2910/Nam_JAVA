package coummunityuni.com.model;

public class Hourly extends Employee {
	private int hoursWorked;
	public void addHours(int moreHours) {
		this.hoursWorked = moreHours;
		
	}
	public double pay() {
		return this.hoursWorked*50;
	}
	public String toString() {
		return super.toString();
	}
}
