package mypack;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Car
{
    @Id Long id;
    String brand;
    String color;
    double price;
    @Transient String doNotPersist;

    Car() {}
    
    public Car(String brand, String color, double price)
    {
        this.brand = brand;
        this.color = color;
        this.price=price;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
    
}
