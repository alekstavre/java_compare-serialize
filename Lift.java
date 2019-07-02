package testpack1;

import java.io.Serializable;

public class Lift implements Comparable<Lift>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int current;
	private int max;
	private int min;
	private int capacity;

	public Lift(int current, int max, int min, int capacity) {
		this.capacity = setCapacity(capacity);
		this.current = setCurrent(current);
		this.max = setMax(max);
		this.min = setMin(min);
	}

	public int getCurrent() {
		return this.current;
	}

	public int setCurrent(int current) {
		return this.current = current;
	}

	public int getMax() {
		return max;
	}

	public int setMax(int max) {
		return this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int setMin(int min) {
		return this.min = min;
	}

	public int getCapacity() {
		return capacity;
	}

	public int setCapacity(int capacity) {
		return this.capacity = capacity;
	}

	public void move(int floor) {
		int position = getCurrent();
		if (floor <= getMax() && floor >= getMin()) {
			if (floor > position) {
				for (int i = position; i < floor; i++) {
					moveUp();
				}
			} else if (floor < position) {
				for (int i = position; i > floor; i--) {
					moveDown();
				}
			} else
				System.out.println("you are already there!");
		} else
			System.out.println("can't go beyond limits!");
	}

	public void moveUp() {
		int position = getCurrent();
		if (position < getMax()) {
			position++;
			setCurrent(position);
			StringBuilder sb = new StringBuilder();
			sb.append("one floor up ");
			sb.append("you are at the: ");
			sb.append(getCurrent());
			sb.append("'th floor");
			System.out.println(sb);
		} else {
			System.out.println("you are at the top floor!");
		}
	}

	public void moveDown() {
		int position = getCurrent();
		if (position > getMin()) {
			position--;
			setCurrent(position);
			StringBuilder sb = new StringBuilder();
			sb.append("one floor down ");
			sb.append("you are at the : ");
			sb.append(getCurrent());
			sb.append("'th floor");
			System.out.println(sb);
		} else {
			System.out.println("you are at the ground floor!");
		}
	}

	public int hashCode() {

		return capacity ^ current ^ max ^ min;

	}

	public boolean equals(Lift lift) {
		boolean equals = false;
		if (this.getCapacity() == lift.getCapacity())
			equals = true;
		return equals;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Elevator");
		sb.append(" capacity:" + getCapacity());
		sb.append(" current floor:" + getCurrent());
		return sb.toString();
	}

	@Override
	public int compareTo(Lift lift) {
		if (this.getCapacity() > lift.getCapacity())
			return 1;
		else if (this.getCapacity() < lift.getCapacity())
			return -1;
		else
			return 0;
	}

}
