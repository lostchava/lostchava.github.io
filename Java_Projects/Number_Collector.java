import java.util.Scanner;
public class A9_1 {
    final static int ARRAY_SIZE = 1000;						//Array size
    public static void main(String[] args) {				
        Scanner input = new Scanner(System.in);				//Input
        
        
        int[] list = new int[ARRAY_SIZE];					//Declarations of array and int
        int numItems;
        
        numItems = readNumbers(list);						//Calling Methods
        System.out.println("You Entered");
        printNumbers(list, numItems);
    }
        
        
        
        
        
        
 
        
        public static int readNumbers(int[] list)			//Reading Numbers Method
        {
        	int number, count;
            Scanner input = new Scanner(System.in);
        	System.out.print(("Enter a non-negative integer (negative to quit): "));	//Prompt user
        	number = input.nextInt();
        	
        	count = 0;
        	while((number >= 0) && ( count < ARRAY_SIZE)) {			//While loop
                if (existingNumbers(count, list, number)) {			//Calling Bool Method
        		list [count] = number;								
        		count++;
                }
        		if (count < ARRAY_SIZE) {								//Array to avoid out of bounds error
        			System.out.print("Enter a non-negative integer (negative to quit): ");
                	number = input.nextInt();

        		}else {
        			System.out.println("the Array is now full. ");			
        		}

        	}
        	return count;
        }
        
        
        
        
        
        
	    public static boolean existingNumbers(int numItems, int list[], int number) {	//Bool to find Duplicate numbers
	    	
	    	for (int count1 = 0; count1 < numItems; count1++){
	    		if (list [count1] == number) {
	    		return false;
	    		}												
	    		}	
	    	return true;
	    	
	    }
        
        
        
        
        
        
              
        public static void printNumbers(int[] list,  int numItems)		//Print Numbers Method 
        {
            int count;
        
            for (count = 0; count < numItems; count++){
                System.out.print(list[count] + " ");
            }
        }
    }

/*
Enter a non-negative integer (negative to quit): 1
Enter a non-negative integer (negative to quit): 2
Enter a non-negative integer (negative to quit): 3
Enter a non-negative integer (negative to quit): 2
Enter a non-negative integer (negative to quit): 1
Enter a non-negative integer (negative to quit): 6
Enter a non-negative integer (negative to quit): 3
Enter a non-negative integer (negative to quit): 4
Enter a non-negative integer (negative to quit): 5
Enter a non-negative integer (negative to quit): 2
Enter a non-negative integer (negative to quit): -4
You Entered
1 2 3 6 4 5 
 
 */