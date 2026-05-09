package coummunityuni.com.model;

public class Executive extends Employee {
	private double bonus;
	public void awardBonus(double bonus) {
		this.bonus = bonus;
		System.out.println("Nhận : "+ bonus);
	}
	public double pay() {
		return super.pay() + this.bonus;
	}
}
