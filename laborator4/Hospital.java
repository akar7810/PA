package laborator4;

public class Hospital implements  Comparable<Hospital> {

    private String name;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Hospital hospital) {
		int comparator = this.getName().compareTo(hospital.getName());
		if(comparator == 0) {
			if(this.getCapacity()>hospital.getCapacity()) {
				return 1;}
		} else {
			return -1;
		}
		return comparator;
    }

    @Override
    public String toString() {
        return "{" + name + " , " + capacity + '}';
    }
}