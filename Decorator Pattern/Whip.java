public class Whip extends CondimentsDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + " Whip";
	}

	public double cost() {
		return beverage.cost() + 0.3;
	}
}