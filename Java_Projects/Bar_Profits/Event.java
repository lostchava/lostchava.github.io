package Java_Projects.Bar_Profits;

public abstract class Event implements Comparable<Event> {
	public final int time;
	public Event (int t) {
		time = t;
	}
	abstract void processEvent ( );
	public int wecompareTo (Object o) {		//comparing the event and times
		Event right = (Event) o;
		if (time < right.time) return -1;
		if (time == right.time) return 0;
		return 1;
	}



}
