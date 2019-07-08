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

	public String move(int floor) {
		int position = getCurrent();
		StringBuilder sb = new StringBuilder();
		if (floor <= getMax() && floor >= getMin()) {
			if (floor > position) {
				for (int i = position; i < floor; i++) {

					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					sb = moveUp();
				}
			} else if (floor < position) {
				for (int i = position; i > floor; i--) {

					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					sb = moveDown();
				}
			} else
				sb.append("you are already there!");
			System.out.println(sb);
		} else
			sb.append("can't go beyond limits!");
		System.out.println(sb);
		String message = sb.toString();
		return message;
	}

	public StringBuilder moveUp() {
		int position = getCurrent();
		StringBuilder sb = new StringBuilder();
		if (position < getMax()) {
			position++;
			setCurrent(position);
			sb.append("one floor up ");
			sb.append("you are at the: ");
			sb.append(getCurrent());
			sb.append("'th floor");

			System.out.println(sb);

		} else {
			sb.append("you are at the top floor!");
			System.out.println(sb);
		}

		return sb;
	}

	public StringBuilder moveDown() {
		int position = getCurrent();
		StringBuilder sb = new StringBuilder();
		if (position > getMin()) {
			position--;
			setCurrent(position);

			sb.append("one floor down ");
			sb.append("you are at the : ");
			sb.append(getCurrent());
			sb.append("'th floor");
			System.out.println(sb);

		} else {
			sb.append("you are at the ground floor!");
			System.out.println(sb);
		}
		return sb;
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
