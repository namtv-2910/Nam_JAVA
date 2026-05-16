package communityuni.com;

public class Invoice {
	private String pastNumber;
	private String pastDiscription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String pastNumber, String pastDiscription, int quantity, double pricePerItem) {
		super();
		this.pastNumber = pastNumber;
		this.pastDiscription = pastDiscription;
		setQuantity(quantity);
		setPricePerItem(pricePerItem);
	}

	public String getPastNumber() {
		return pastNumber;
	}

	public void setPastNumber(String pastNumber) {
		this.pastNumber = pastNumber;
	}

	public String getPastDiscription() {
		return pastDiscription;
	}

	public void setPastDiscription(String pastDiscription) {
		this.pastDiscription = pastDiscription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity >0) {
			this.quantity = quantity;
		}
		else {
			this.quantity = 0;
		}
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		if(pricePerItem >0) {
			this.pricePerItem = pricePerItem;
		}
		else {
			this.pricePerItem = 0.0;
		}
	}
	
	public double getInvoiceAmount() {
		return quantity * pricePerItem;
	}
	
	public void layThongTin() {
		System.out.println("Mã hàng: "+ pastNumber);
		System.out.println("Mô tả: "+ pastDiscription);
		System.out.println("Số lượng: "+ quantity);
		System.out.println("Giá: "+ pricePerItem);
		System.out.println("Thành tiền: "+ getInvoiceAmount());
		
		
	}
	
	

}
