package lab3;

public class Book implements Item{
	private String name;
	private double value,weight;
	private double profit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProfit() {
		return profitFactor(value,weight);
	}
	public double getValue() {
		return value;
	}

	public Book(String name, int value, int wheight) {
		super();
		this.name = name;
		this.value = value;
		this.weight = wheight;
	}

	public double getWeight() {
		return weight;
	}
	
}
