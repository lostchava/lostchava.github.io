package Java_Projects.Bar_Profits;
import java.util.Vector; //vector import
import java.util.Random; //random seeder import
/*
 * Beers-Bars-Drinkers
 * Assignment 3
 * 
 * <Andrew Sprague>
 * 10/13/21
 * 
 * The purpose of this program is to run a bar simulation on a random night of service. The simualtion is 
 * ran three times each time including a different amount of seats available. This is so we can get different
 * bar sizes in our simulation. The first bar is twenty five seats, the second is sixty and the thrid is one hundred. The bar 
 * also includes weighted random size groups of people coming into the bar and ordering beer from the menu. The beer ordered 
 * is weighted to match what the bar usually would suspect to see ordered. Once each group orders a round of beers
 * there beer profit is added to the total. The group then is faced with the decision to stay or to order another round of beer.
 * Once the groups are done with their beer they leave the Queue and free up space in the bar to take more groups. If there is no space
 * in the Queue then the group leaves the bar until another group of people have left, freeing up space.
 * This is all handled with events that are put into a Heap Priority Queue, where we simulate the sequnce of events in the order given.
 * This simulation runs for four hours after the time has come to an end the Total profits is printed out. Part of the code is given by the professor 
 * and is the adaptation from his code and from Robert Sedgewick and Kevin Wayne. This along with the code I have given is able to produce this simualtion
 * of a typical night in the bar.
 * 
 */

public class SoftwareGurusBar {
	private int seed = 124775509; // seed
	private int freeChairs = 25; // should be a verified user param
	private double profit = 0.0; //starting profits
	private SimulationFramework simulation = new SimulationFramework( );



	public static void main (String [ ] args) {
		SoftwareGurusBar world = new SoftwareGurusBar ( );
	}



	SoftwareGurusBar ( ) {
		int t = 0; 		//starting time
		while (t < 240) { // simulate 4 hours of bar operation
			t += randBetween(2, 5); // new group every 2-5 minutes

			simulation.scheduleEvent(new ArriveEvent(t, simulation.weightedProbabilityGroup(probGroup())));// group size ranges from 1 to 5

		}
		simulation.run( );


		System.out.println("Total profits " + profit);
	}
	//random number generator
	private int randBetween (int low, int high) {
		return low + (int) ((high - low + 1) * Math.random( ));
	}


	//vector for beer
	public Vector<Integer> prob() {
		int [] randomNums = RandomSeed(seed, 3);	//random seeds drinking pattern

		Vector<Integer> prob = new Vector<>();
		prob.add(randomNums[0]);	// for beer 0
		prob.add(randomNums[1]);	// for beer 1
		prob.add(randomNums[2]);	// for beer 2
		return prob;
	}
	//vector for groups
	public Vector<Integer> probGroup() {
		Vector<Integer> prob = new Vector<>();
		prob.add(10);	// for group size 1
		prob.add(30);	// for group size 2
		prob.add(50);	// for group size 3
		prob.add(30);	// for group size 4
		prob.add(15);	// for group size 5
		return prob;
	}



	//can't sit/ more people than seats
	public boolean canSeat (int numberOfPeople) {
		System.out.println("Group of " + numberOfPeople +
				" customers arrives at time " + simulation.time( ));

		if (numberOfPeople < freeChairs) {
			System.out.println("Group is seated");
			freeChairs -= numberOfPeople;
			return true;
		} 

		else
			System.out.println("No Room, Group Leaves");
		return false;
	}
	//Beer Type and profit
	public void order (int beerType) {
		System.out.println("Serviced order for beer type " + beerType +
				" at time " + simulation.time( ));
		// update profit knowing beerType (left for you)
		if (beerType == 0) {
			profit+=2.0;		
		}
		else if (beerType == 1) {
			profit+=3.0;
		}
		else if (beerType == 2) {
			profit+=4.0;
		}
	}






	//people leaving 
	public void leave (int numberOfPeople) {
		System.out.println("Group of size " + numberOfPeople +
				" leaves at time " + simulation.time( ));
		freeChairs += numberOfPeople;
	}




	//arrive event 
	private class ArriveEvent extends Event {
		private int groupSize;
		ArriveEvent (int time, int gs) { super(time); groupSize = gs; }
		public void processEvent ( ) {
			if (canSeat(groupSize)) {
				// place an order within 2 & 10 minutes
				simulation.scheduleEvent (new OrderEvent(time + randBetween(2,10),groupSize));
			}
		}
		@Override
		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}








	private class OrderEvent extends Event {
		private int groupSize;
		OrderEvent (int time, int gs) { 
			super(time); groupSize = gs; 
		}

		public void processEvent ( ) {
			// each member of the group orders a beer (type 1,2,3)
			for (int i = 0; i < groupSize; i++)
				order(simulation.weightedProbability(prob()));
			// schedule a leaveEvent for this group
			// all the group leaves together (left for you)

			//Reorder event if statment followed with a LeaveEvent both are scheduled 
			if (time<220) {
				simulation.scheduleEvent (new ReOrderEvent(time + randBetween(2,10),groupSize));
			}
			simulation.scheduleEvent (new LeaveEvent(time + randBetween(30,60),groupSize));


		}
		@Override
		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}




	//Reorder option
	private class ReOrderEvent extends Event {
		private int groupSize;
		private int counter = 1;
		ReOrderEvent(int t, int group) {
			super(t); groupSize = group;
		} 
		public void processEvent ( ) {								
			int randBetween = randBetween(1,10)/counter;	//Diminishing probability
			if(randBetween>3 && time<220) {					//So you don't have orders after they leave helps not having infinite reorders
				order(simulation.weightedProbability(prob()));	//Weighted probability for beer
				simulation.scheduleEvent (new ReOrderEvent(time + randBetween(2,10),groupSize)); //scheduling an Event to reOrder
				counter++; //counter to help with dimishing probability
			}



		}

		@Override
		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			return 0;
		}

	}








	//leaving event
	private class LeaveEvent extends Event {
		LeaveEvent (int time, int gs) { super(time); groupSize = gs; }
		private int groupSize;

		public void processEvent ( ) { leave(groupSize); }
		@Override

		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	

	//random seed generator 
    public static int[] RandomSeed(long seed, int amount) {
        int[] seedList = new int[amount];
        for (int i=0;i<amount;i++) {
            Random generator = new Random(seed);
            seedList[i] = Math.abs((int) (generator.nextLong() % 10)* 10);
            seed--;
        }
        return seedList;
    }
}
