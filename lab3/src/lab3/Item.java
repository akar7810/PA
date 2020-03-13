package lab3;

public interface Item {

	default double profitFactor(double value, double weight) {
		return value/weight;
	}

	double getProfit();

	double getWeight();

	double getValue();

	String getName();
	
}
