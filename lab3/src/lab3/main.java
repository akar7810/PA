package lab3;

public class main {
	public static void main(String[] args) {
		Knapsack bag= new Knapsack(10);
		Book book1 = new Book("Dragon Rising",5,3);
		Book book2 = new Book("A blade in the Dark",5,3);
		Food food1 = new Food("Cabbge",4,2);
		Food food2 = new Food("Rabbit",5,2);
		Weapon weapon1 = new Weapon("Sword",10,5);

		bag.addItem(book1);
		bag.addItem(book2);
		bag.addItem(food1);
		bag.addItem(food2);
		bag.addItem(weapon1);
		bag.problem();

		
	}
}
