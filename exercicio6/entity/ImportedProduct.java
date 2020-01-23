package entity;

public class ImportedProduct extends Product1 {
	private Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public void totalPrice() {
		setPrice(getPrice() + customsFee);
	}
	
	@Override
	public final String priceTag() {
		totalPrice();
		return super.priceTag() + 
				" (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
	}
}
