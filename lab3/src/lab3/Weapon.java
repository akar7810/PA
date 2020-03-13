package lab3;

public class Weapon implements Item{
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
		return profit;
	}
	public double getValue() {
		return value;
	}
	public Weapon(String name, int value, int wheight) {
		super();
		this.name = name;
		this.value = value;
		this.weight = wheight;
		this.profit=profitFactor(value, weight);
	}
	public double getWeight() {
		return weight;
	}
}
