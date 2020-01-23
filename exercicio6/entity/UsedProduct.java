package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product1 {
	private Date manufactureDate;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public final String priceTag() {
		return getName() + " (used) $ " + String.format("%.2f", getPrice()) + 
				"(Manufacture date: " + 
				sdf.format(manufactureDate) + ")";
	}
}
