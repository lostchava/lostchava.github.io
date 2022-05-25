import java.util.Comparator;
import java.util.Vector;
package Java_Projects.Bar_Profits;

public class SimulationFramework {
	private int currentTime = 0;
	public int time ( ) { return currentTime; }
	private MinPQ eventQueue = new MinPQ(new DefaultComparator( ));

	public void scheduleEvent (Event newEvent) {
		// put or addElement “newEvent” to the “eventQueue”
		// MinHeap Priority Queue (left for you)
		eventQueue.insert(newEvent);
	}
	public void run ( ) {
		while (! eventQueue.isEmpty( )) {
			// remove min element from priority queue (Min Heap)
			Event nextEvent = (Event) eventQueue.delMin( );
			currentTime = nextEvent.time;
			nextEvent.processEvent( ); // What do we have here???
		}
	}



	public class DefaultComparator implements Comparator<Event> {
		public int compare(Event o1, Event o2) {
			return o1.wecompareTo(o2);
		}
	}



	//weighted probabililty for drinks 
	public int weightedProbability(Vector<Integer> prob) {

		int sum = 0;
		for( int num : prob) {
			sum = sum+num;
		}

		int randBetween = randBetween(1,sum);

		if (randBetween <= prob.get(0)) {
			return 0;	//mid level probability of getting this drink
		}
		else if (randBetween <= (prob.get(1)+ prob.get(0))) {
			return 1;	//mid level probability of getting this drink
		}
		else  {
			return 2;	//very low chance to get less than 10%
		}

	}
	//random number generator
	private int randBetween (int low, int high) {
		return low + (int) ((high - low + 1) * Math.random( ));
	}
	//weighted probability for groups
	public int weightedProbabilityGroup(Vector<Integer> probGroup) {
		int counter = 0;
		int sum = 0;
		for( int num : probGroup) {
			sum = sum+num;
		}

		int randBetween = randBetween(1,sum);

		if (randBetween <= probGroup.get(0)) {
			return 1;	//group of 1
		}
		else if (randBetween <= (probGroup.get(1)+ probGroup.get(0))) {
			return 2;	//group of 2
		}
		else if (randBetween <= (probGroup.get(2)+probGroup.get(1)+ probGroup.get(0))) {
			return 3;	//group of 3
		}
		else if (randBetween <= (probGroup.get(3)+probGroup.get(2)+probGroup.get(1)+ probGroup.get(0))) {
			return 4;	//group of 4
		}
		else {
			return 5;	//group of 5
		}

	}
}


